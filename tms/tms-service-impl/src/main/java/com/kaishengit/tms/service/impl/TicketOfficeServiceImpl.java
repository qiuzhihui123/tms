package com.kaishengit.tms.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.entity.base.TicketOfficeAccount;
import com.kaishengit.tms.entity.base.TicketOfficeAccountExample;
import com.kaishengit.tms.entity.base.TicketOfficeInfermation;
import com.kaishengit.tms.entity.base.TicketOfficeInfermationExample;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.mapper.base.TicketOfficeAccountMapper;
import com.kaishengit.tms.mapper.base.TicketOfficeInfermationMapper;
import com.kaishengit.tms.service.TicketOfficeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *@Description:处理售票点先关service的实现类
 *@Author: 邱志辉
 *@Date 2016/4/19 0019下午 4:42
 */
@Service
public class TicketOfficeServiceImpl implements TicketOfficeService {

    @Autowired
    TicketOfficeInfermationMapper ticketOfficeInfermationMapper;
    @Autowired
    TicketOfficeAccountMapper ticketOfficeAccountMapper;

    private Logger logger = LoggerFactory.getLogger(TicketOfficeServiceImpl.class);


    /**
     * @描述: 查询出所有的售票点对象返回
     * @参数:[]
     * @返回值java.util.List<com.kaishengit.tms.entity.TicketOfficeInfermation> 售票点的List集合
     */
    @Override
    public List<TicketOfficeInfermation> findAllTicketOffices() {
        TicketOfficeInfermationExample ticketOfficeInfermationExample = new TicketOfficeInfermationExample();
        return ticketOfficeInfermationMapper.selectByExample(ticketOfficeInfermationExample);
    }

    /**
     * @param ticketOfficeInfermation
     * @描述: 根据售票点信息对象创建售票点并创建售票点帐号
     * @参数:[ticketOfficeInfermation]
     * @返回值void
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void addATicketOffice(TicketOfficeInfermation ticketOfficeInfermation) {
        //信息登记
        ticketOfficeInfermation.setTicketOfficeStatus(TicketOfficeInfermation.OFFICE_NOMAL_STATUS);
        ticketOfficeInfermationMapper.insertSelective(ticketOfficeInfermation);
        //创建帐号
        TicketOfficeAccount ticketOfficeAccount = new TicketOfficeAccount();
        ticketOfficeAccount.setId(ticketOfficeInfermation.getId());
        ticketOfficeAccount.setTicketOfficeAccountName(ticketOfficeInfermation.getLegalPersonMobile());
        //截取售票点信息后六位作为帐号密码
        ticketOfficeAccount.setTicketOfficeAccountPassword(ticketOfficeInfermation.getLegalPersonMobile().substring(5));
        ticketOfficeAccount.setStatus(TicketOfficeAccount.ACCOUNT_NOMAL_STATUS);
        ticketOfficeAccount.setDeleted(TicketOfficeAccount.ACCOUNT_IS_DELETED);
        ticketOfficeAccountMapper.insertSelective(ticketOfficeAccount);

        logger.info("新增销售点{},以及其对应的帐号{}",ticketOfficeInfermation,ticketOfficeAccount);
    }

    /**
     *@描述:根据售票点的id查找售票点对象以及它对应的account
     *@参数:[id] 售票点的id
     *@返回值com.kaishengit.tms.entity.base.TicketOfficeInfermation 售票点对象
     */
    @Override
    public TicketOfficeInfermation findOfficeWithAccountByOfficeId(Integer id) {
        return ticketOfficeInfermationMapper.findOfficeWithAccountByOfficeId(id);
    }

    /**
     * @描述: 根据新的售票点对象更新该对象
     * @参数:[newOffice] 新的售票点对象
     * @返回值void
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateOfficeAndAccountByOfficeId(TicketOfficeInfermation newOffice) {
        //根据id查找售票点对象
        TicketOfficeInfermationExample ticketOfficeInfermationExample = new TicketOfficeInfermationExample();
        ticketOfficeInfermationExample.createCriteria().andIdEqualTo(newOffice.getId());
        List<TicketOfficeInfermation> officeList = ticketOfficeInfermationMapper.selectByExample(ticketOfficeInfermationExample);
        TicketOfficeInfermation oldOffice = officeList.get(0);
        TicketOfficeAccount oldAccount = ticketOfficeAccountMapper.selectByPrimaryKey(newOffice.getId());

        if(officeList!= null && !officeList.isEmpty()){
            newOffice.setUpdateTime(new Date());
            ticketOfficeInfermationMapper.updateByPrimaryKeySelective(newOffice);
           //更新相关联的帐号
            TicketOfficeAccount ticketOfficeAccount = ticketOfficeAccountMapper.selectByPrimaryKey(newOffice.getId());
            ticketOfficeAccount.setTicketOfficeAccountName(newOffice.getLegalPersonMobile());
            ticketOfficeAccount.setTicketOfficeAccountPassword(newOffice.getLegalPersonMobile().substring(5));
            ticketOfficeAccount.setUpdateTime(new Date());
            ticketOfficeAccountMapper.updateByPrimaryKeySelective(ticketOfficeAccount);

            logger.info("更新了销售点{}为{}，更新销售点对应帐号{}为{}",oldOffice,newOffice,oldAccount,ticketOfficeAccount);

        }else {
            throw  new ServiceException("该售票点不存在");
        }

    }

    /**
     * @param id
     * @描述:根据售票点id删除售票点相关
     * @参数:[id] 售票点id
     * @返回值void
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void deleteOfficeByOfficeId(Integer id) {
        //查出销售点和帐号用于记录日志
        TicketOfficeAccount account = ticketOfficeAccountMapper.selectByPrimaryKey(id);
        TicketOfficeInfermation office = ticketOfficeInfermationMapper.selectByPrimaryKey(id);

        //删除对应id的帐号和销售点
        ticketOfficeAccountMapper.deleteByPrimaryKey(id);
        ticketOfficeInfermationMapper.deleteByPrimaryKey(id);

        logger.info("删除了销售点{},以及对应帐号{}",office,account);
    }

    /**
     * @param id
     * @描述:根据id禁用销售点帐号
     * @参数:[id]
     * @返回值void
     */
    @Override
    public void forbiddenOfficeAccountById(Integer id) {
        //根据id找到账户把其状态修改为禁用
        TicketOfficeAccountExample ticketOfficeAccountExample = new TicketOfficeAccountExample();
        ticketOfficeAccountExample.createCriteria().andIdEqualTo(id);
        List<TicketOfficeAccount> accountList = ticketOfficeAccountMapper.selectByExample(ticketOfficeAccountExample);

        //找到该账户
        TicketOfficeAccount account = accountList.get(0);

        if(TicketOfficeAccount.ACCOUNT_NOMAL_STATUS.equals(account.getStatus())){
            account.setStatus(TicketOfficeAccount.ACCOUNT_FORBIDDEN_STATUS);
            account.setUpdateTime(new Date());

            ticketOfficeAccountMapper.updateByPrimaryKeySelective(account);
            logger.info("禁用账户,{}",account);
        }else {
            account.setStatus(TicketOfficeAccount.ACCOUNT_NOMAL_STATUS);
            account.setUpdateTime(new Date());

            ticketOfficeAccountMapper.updateByPrimaryKeySelective(account);
            logger.info("启用账户,{}",account);
        }

    }

    /**
     * @param accountMobile
     * @描述:根据售票点电话找到对应的售票点信息
     * @参数:[accountMobile]
     * @返回值com.kaishengit.tms.entity.base.TicketOfficeInfermation
     */
    @Override
    public TicketOfficeInfermation findOfficeByAccountMobile(String accountMobile) {
        TicketOfficeInfermationExample ticketOfficeInfermationExample = new TicketOfficeInfermationExample();
        ticketOfficeInfermationExample.createCriteria().andLegalPersonMobileEqualTo(accountMobile);

        return ticketOfficeInfermationMapper.selectByExample(ticketOfficeInfermationExample).get(0);

    }

    /**
     * @param accountMobile
     * @描述:根据电话查找对应的销售点帐号
     * @参数:[accountMobile]
     * @返回值com.kaishengit.tms.entity.base.TicketOfficeAccount
     */
    @Override
    public TicketOfficeAccount findOfficeAccountByMobile(String accountMobile) {
        TicketOfficeAccountExample ticketOfficeAccountExample = new TicketOfficeAccountExample();
        ticketOfficeAccountExample.createCriteria().andTicketOfficeAccountNameEqualTo(accountMobile);
        return ticketOfficeAccountMapper.selectByExample(ticketOfficeAccountExample).get(0);

    }

    /**
     * @param p
     * @param paramMap
     * @描述:根据页码和条件查询对应的销售点集合
     * @参数:[p, paramMap]
     * @返回值com.github.pagehelper.PageInfo<com.kaishengit.tms.entity.base.TicketOfficeInfermation>
     */
    @Override
    public PageInfo<TicketOfficeInfermation> findOfficesByParamsMap(Integer p, Map<String, Object> paramMap) {
        PageHelper.startPage(p,TicketOfficeInfermation.PAGE_SIZE);
        List<TicketOfficeInfermation> officeList = ticketOfficeInfermationMapper.findOfficesByParamsMap(paramMap);

        return new PageInfo<TicketOfficeInfermation>(officeList);
    }


}
