package com.kaishengit.tms.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.entity.ticket.Ticket;
import com.kaishengit.tms.entity.ticket.TicketInRecord;
import com.kaishengit.tms.entity.ticket.TicketOutRecord;

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
    void ticketInByRecord(TicketInRecord ticketInRecord);

    /**
     *@描述:根据传来的页码查询相应的出库记录并封装到PageInfo对象中返回
     *@参数:[p] 当前页码默认为1
     *@返回值com.github.pagehelper.PageInfo<com.kaishengit.tms.entity.ticket.TicketOutRecord>
     */
    PageInfo<TicketOutRecord> findAllTicketOutRecordByPage(Integer p);
    
    /** 
     *@描述:新增下发记录
     *@参数:[ticketOutRecord]
     *@返回值void
     */
    void ticketOutRecordNew(TicketOutRecord ticketOutRecord);
}
