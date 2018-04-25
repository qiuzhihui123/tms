package com.kaishengit.tms.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.entity.base.TicketOfficeInfermation;
import com.kaishengit.tms.entity.manage.Account;
import com.kaishengit.tms.entity.ticket.*;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.mapper.base.TicketOfficeInfermationMapper;
import com.kaishengit.tms.mapper.ticket.TicketInRecordMapper;
import com.kaishengit.tms.mapper.ticket.TicketMapper;
import com.kaishengit.tms.mapper.ticket.TicketOutRecordMapper;
import com.kaishengit.tms.service.TicketService;
import com.kaishengit.tms.util.ShiroUtil;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 *@Description: 处理ticket业务相关的service实现类
 *@Author: 邱志辉
 *@Date 2016/4/22 0022下午 10:14
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketInRecordMapper ticketInRecordMapper;
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private TicketOutRecordMapper ticketOutRecordMapper;
    @Autowired
    private TicketOfficeInfermationMapper ticketOfficeInfermationMapper;

    private static Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

    /**
     * @param p
     * @描述:根据页码查询相应的入库记录的list
     * @参数:[p] 页码
     * @返回值com.github.pagehelper.PageInfo<com.kaishengit.tms.entity.ticket.TicketInRecord>
     */
    @Override
    public PageInfo<TicketInRecord> findAllTicketSRecordByPage(Integer p) {
        PageHelper.startPage(p,TicketInRecord.PAGE_SIZE);

        TicketInRecordExample ticketInRecordExample = new TicketInRecordExample();
       List<TicketInRecord> ticketInRecordList =  ticketInRecordMapper.selectByExample(ticketInRecordExample);

       return new PageInfo<TicketInRecord>(ticketInRecordList);
    }

    /**
     * @param ticketInRecord
     * @描述:根据TicketInRecord对象插入入库记录
     * @参数:[ticketInRecord]
     * @返回值void
     */
    @Override
    public void ticketInByRecord(TicketInRecord ticketInRecord) {
        BigInteger startNum = new BigInteger(ticketInRecord.getStartTicketNum());
        BigInteger endNum = new BigInteger(ticketInRecord.getEndTicketNum());

        //判断是否与之前的票号入库票号区间重复
        TicketInRecordExample ticketInRecordExample = new TicketInRecordExample();
        List<TicketInRecord> ticketInRecordList = ticketInRecordMapper.selectByExample(ticketInRecordExample);
        for(TicketInRecord inRecord : ticketInRecordList){
            BigInteger start = new BigInteger(inRecord.getStartTicketNum());
            BigInteger end = new BigInteger(inRecord.getEndTicketNum());

            if(startNum.compareTo(start) >= 0 && startNum.compareTo(end) <= 0 || endNum.compareTo(start) >= 0 && endNum.compareTo(end) <=0 ){
                throw  new ServiceException("该票号区间重复录入，请查证后再试");
            }

        }

        //入库时间
        ticketInRecord.setCreateTime(new Date());
        //计算总数量

        BigInteger totalNum = endNum.subtract(startNum).add(new BigInteger(String.valueOf(1)));

        int total = totalNum.intValue();
        ticketInRecord.setTotalNum(total);

        //当前对象
        Account account  = ShiroUtil.getCurrentAccount();
        ticketInRecord.setAccountId(account.getId());
        ticketInRecord.setAccountName(account.getAccountName());

        //入库记录,起始票号
        ticketInRecord.setContent(ticketInRecord.getStartTicketNum() +"-"+ticketInRecord.getEndTicketNum());
        ticketInRecordMapper.insertSelective(ticketInRecord);
        logger.info("新增入库{}，入库人{}",ticketInRecord,account);

        //根据起始票号录入年票
        List<Ticket> ticketList = new ArrayList<>();
        for(int i = 0;i<total;i++){
            Ticket ticket = new Ticket();
            ticket.setCreateTime(new Date());
            ticket.setTicketInTime(new Date());
            ticket.setTicketNum(startNum.add(new BigInteger(i + "")).toString());
            ticket.setStatus(Ticket.TICKET_STATE_IN_STORE);
            ticketList.add(ticket);
        }
         ticketMapper.batchInsert(ticketList);
    }

    /**
     * @param id
     * @描述: 根据入库id删除相应的入库记录
     * @参数:[id]
     * @返回值void
     */
    @Override
    public void inRecordDelByRecordID(Integer id) throws ServiceException {
        TicketInRecord ticketInRecord = ticketInRecordMapper.selectByPrimaryKey(id);
        //找到入库记录再说删除
        if(ticketInRecord != null){
            //查找出该记录对应的年票集合

            List<Ticket> ticketList =ticketMapper.selectTicketsByStartAndEndNum(ticketInRecord.getStartTicketNum(),
                                                                                    ticketInRecord.getEndTicketNum(),
                                                                                    Ticket.TICKET_STATE_IN_STORE);

            if(!ticketInRecord.getTotalNum().equals(ticketList.size())){
                throw  new ServiceException("该批次年票存在已出库，请查证后再试");
            }

            //通过判断后才能删除
            List<Long> ticketIds = new ArrayList<>();
            for(Ticket ticket : ticketList){
                ticketIds.add(ticket.getId());
            }

            ticketMapper.batchDeleteByIdList(ticketIds);
            ticketInRecordMapper.deleteByPrimaryKey(id);

        }
    }

    /**
     * @param id
     * @描述:根据id删除相应的下发记录，如果该记录是已支付，不能删除
     * @参数:[id]
     * @返回值void
     */
    @Override
    public void outRecordDelById(Integer id) {
        TicketOutRecord ticketOutRecord = ticketOutRecordMapper.selectByPrimaryKey(id);
        if(ticketOutRecord != null && TicketOutRecord.NON_PAYMENT_STATUS.equals(ticketOutRecord.getStatus())){
            ticketOutRecordMapper.deleteByPrimaryKey(id);
        }
    }

    /**
     * @描述:查出盘点统计需要数据，如总数数量，已入库数量，已下发数量等
     * @参数:[]
     * @返回值java.util.Map<java.lang.String,java.lang.String>
     */
    @Override
    public Map<String, Long> findChartsOfTicket() {
        Map<String,Long> map = ticketMapper.countByStatus();

        return map;
    }

    /**
     * @param id
     * @描述:根据id查询出对应的下发记录
     * @参数:[id]
     * @返回值com.kaishengit.tms.entity.ticket.TicketOutRecord
     */
    @Override
    public TicketOutRecord findTIcketOutRecordById(Integer id) {
        return ticketOutRecordMapper.selectByPrimaryKey(id);
        }

    /**
     * @param ticketOutRecord
     * @描述:修改下发记录为已支付，并修改关联的数据
     * @参数:[ticketOutRecord]
     * @返回值void
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void ticketInByRecordPaid(TicketOutRecord ticketOutRecord) {

        TicketOutRecord outRecord = ticketOutRecordMapper.selectByPrimaryKey(ticketOutRecord.getId());
        if(outRecord != null && TicketOutRecord.NON_PAYMENT_STATUS.equals(outRecord.getStatus())){
            //记录改为已支付，设置支付类型
             outRecord.setStatus(TicketOutRecord.HAVE_PAID_STATUS);
             outRecord.setPayType(ticketOutRecord.getPayType());

             //设置收款人
            Account account = ShiroUtil.getCurrentAccount();
            outRecord.setFinanceAccountId(account.getId());
            outRecord.setFinanceAccountName(account.getAccountName());

            //修改该段年票状态
            List<Ticket> ticketList = ticketMapper.selectTicketsByStartAndEndNum(outRecord.getStartTicketNum(),
                    outRecord.getEndTicketNum(),
                    Ticket.TICKET_STATE_IN_STORE);

            //修改该集合的年票属性
            for(Ticket ticket :ticketList){
                ticket.setUpdateTime(new Date());
                ticket.setTicketOutTime(new Date());
                ticket.setOfficeId(outRecord.getOfficeId());
                ticket.setStatus(Ticket.TICKET_STATE_OUT_STORE);

                ticketMapper.updateByPrimaryKeySelective(ticket);
            }
            //更新下发记录
            outRecord.setUpdateTime(new Date());
            ticketOutRecordMapper.updateByPrimaryKeySelective(outRecord);

        }

    }

    /**
     * @param p
     * @描述:根据传来的页码查询相应的出库记录并封装到PageInfo对象中返回
     * @参数:[p] 当前页码默认为1
     * @返回值com.github.pagehelper.PageInfo<com.kaishengit.tms.entity.ticket.TicketOutRecord>
     */
    @Override
    public PageInfo<TicketOutRecord> findAllTicketOutRecordByPage(Integer p ,String status) {
        //设置分页属性
        PageHelper.startPage(p,TicketOutRecord.PAGE_SIZE);

        //查找相应的出库记录的list

        TicketOutRecordExample ticketOutRecordExample = new TicketOutRecordExample();
        if(TicketOutRecord.HAVE_PAID_STATUS.equals(status) || TicketOutRecord.NON_PAYMENT_STATUS.equals(status)){
            ticketOutRecordExample.createCriteria().andStatusEqualTo(status);
        }
        ticketOutRecordExample.setOrderByClause("id desc");

        List<TicketOutRecord> ticketOutRecordList = ticketOutRecordMapper.selectByExample(ticketOutRecordExample);

        return new PageInfo<TicketOutRecord>(ticketOutRecordList);

    }

    /**
     * @param ticketOutRecord
     * @描述:新增下发记录
     * @参数:[ticketOutRecord] 下发记录
     * @Throws ServiceException 保存失败抛出的异常
     * @返回值void
     */
    @Override
    public void ticketOutRecordNew(TicketOutRecord ticketOutRecord) throws ServiceException{

        BigInteger startTicketNum = new BigInteger(ticketOutRecord.getStartTicketNum());
        BigInteger endTicketNum = new BigInteger(ticketOutRecord.getEndTicketNum());

        if(startTicketNum.compareTo(endTicketNum) > 0){
            throw new ServiceException("输入有误，请重新输入");
        }

        //判断输入的结束票号是否在现有的票号范围之内如果没有，抛出异常
        Integer maxNum = ticketMapper.findMaxNumInTicket();
        BigInteger maxTicketNum = new BigInteger(maxNum + "");


        if(endTicketNum.compareTo(maxTicketNum) > 0){
            throw new ServiceException("库存不足");
        }

        //判断该起始票号内有没有已下发的票如果有则抛出异常

        //查找该号码段有没有不是已入库的年票
        List<TicketOutRecord> ticketOutRecordList = ticketOutRecordMapper.findOutRecordBetweenStartAndEndNum(
                                    ticketOutRecord.getStartTicketNum(),
                                    ticketOutRecord.getEndTicketNum(),
                                    Ticket.TICKET_STATE_IN_STORE);
        if(ticketOutRecordList != null && !ticketOutRecordList.isEmpty()){
            throw new ServiceException("该号码段存在已出库年票，请查证后再试");
        }

        ticketOutRecord.setCreateTime(new Date());

        //下发人，当前登录的帐号
        Account acocunt = ShiroUtil.getCurrentAccount();
        ticketOutRecord.setOutAccountName(acocunt.getAccountName());
        ticketOutRecord.setOutAccountId(acocunt.getId());


        //总数量
        BigInteger startNum = new BigInteger(ticketOutRecord.getStartTicketNum());
        BigInteger endNum = new BigInteger(ticketOutRecord.getEndTicketNum());

        int totalNum = endNum.subtract(startNum).add(new BigInteger(1+"")).intValue();
        ticketOutRecord.setTotalNum(totalNum);

        //总价
        BigDecimal totalPrice = ticketOutRecord.getPrice().multiply(new BigDecimal(totalNum));

        ticketOutRecord.setTotalPrice(totalPrice);

        //状态
        ticketOutRecord.setStatus(TicketOutRecord.NON_PAYMENT_STATUS);

        //售票点名称
        TicketOfficeInfermation ticketOfficeInfermation = ticketOfficeInfermationMapper.selectByPrimaryKey(ticketOutRecord.getOfficeId());
        ticketOutRecord.setOfficeName(ticketOfficeInfermation.getOfficeName());

        //content(起始票号)
        ticketOutRecord.setContent(ticketOutRecord.getStartTicketNum()+"-"+ticketOutRecord.getEndTicketNum());

        ticketOutRecordMapper.insertSelective(ticketOutRecord);

        logger.info("新增下发记录,{}",ticketOutRecord);
    }


}
