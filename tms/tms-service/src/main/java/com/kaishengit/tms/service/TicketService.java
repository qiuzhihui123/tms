package com.kaishengit.tms.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.entity.base.Customer;
import com.kaishengit.tms.entity.base.TicketOfficeInfermation;
import com.kaishengit.tms.entity.manage.Account;
import com.kaishengit.tms.entity.ticket.Ticket;
import com.kaishengit.tms.entity.ticket.TicketInRecord;
import com.kaishengit.tms.entity.ticket.TicketOutRecord;
import com.kaishengit.tms.exception.ServiceException;

import java.math.BigDecimal;
import java.util.Map;

/**
 *@Description: 处理ticket业务相关的service接口
 *@Author: 邱志辉
 *@Date 2016/4/22 0022下午 10:12
 */
public interface TicketService {


    /**
     *@描述:根据页码查询相应的入库记录的list
     *@参数:[p]
     *@返回值com.github.pagehelper.PageInfo<com.kaishengit.tms.entity.ticket.TicketInRecord>
     */
    PageInfo<TicketInRecord> findAllTicketSRecordByPage(Integer p);

    /** 
     *@描述:根据TicketInRecord对象插入入库记录
     *@参数:[ticketInRecord]
     *@返回值void
     */
    void ticketInByRecord(TicketInRecord ticketInRecord,Account account);

    /**
     *@描述:根据传来的页码查询相应的出库记录并封装到PageInfo对象中返回
     *@参数:[p] 当前页码默认为1
     *@返回值com.github.pagehelper.PageInfo<com.kaishengit.tms.entity.ticket.TicketOutRecord>
     */
    PageInfo<TicketOutRecord> findAllTicketOutRecordByPage(Integer p,String status);
    
    /** 
     *@描述:新增下发记录
     *@参数:[ticketOutRecord]
     *@返回值void
     */
    void ticketOutRecordNew(TicketOutRecord ticketOutRecord,Account account);

    /**
     *@描述: 根据入库id删除相应的入库记录
     *@参数:[id]
     *@返回值void
     */
    void inRecordDelByRecordID (Integer id)throws ServiceException;

    /** 
     *@描述:根据id删除相应的下发记录
     *@参数:[id]
     *@返回值void
     */
    void outRecordDelById(Integer id);

    /** 
     *@描述:查出盘点统计需要数据，如总数数量，已入库数量，已下发数量等
     *@参数:[]
     *@返回值java.util.Map<java.lang.String,java.lang.String>
     */
    Map<String,Long> findChartsOfTicket();

    /**
     *@描述:根据id查询出对应的下发记录
     *@参数:[id]
     *@返回值com.kaishengit.tms.entity.ticket.TicketOutRecord
     */
    TicketOutRecord findTIcketOutRecordById(Integer id);

    /** 
     *@描述:修改下发记录为已支付，并修改关联的数据
     *@参数:[ticketOutRecord]
     *@返回值void
     */
    void ticketInByRecordPaid(TicketOutRecord ticketOutRecord,Account account);

    /**
     *@描述:根据销售点的id查询该售票点的销售信息封装成map返回
     *@参数:[id]
     *@返回值java.util.Map<java.lang.String,java.lang.Long>
     */
    Map<String,Long> findChartsOfTicketOfOneOfficeByOfficeId(Integer id);

    /** 
     *@描述:保存开卡记录
     *@参数:[customer, ticketNum, ticketPrice, office]
     *@返回值void
     */
    void saveCustomerWithTicket(Customer customer, String ticketNum, BigDecimal ticketPrice, TicketOfficeInfermation office) throws ServiceException;

    /** 
     *@描述:根据年票票号查找该年票
     *@参数:[ticketNum]
     *@返回值com.kaishengit.tms.entity.ticket.Ticket
     */
    Ticket findTicketByTicketNum(String ticketNum,TicketOfficeInfermation office) throws ServiceException;
}
