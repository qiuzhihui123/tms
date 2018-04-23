package com.kaishengit.tms.mapper.ticket;

import com.kaishengit.tms.entity.ticket.Ticket;
import com.kaishengit.tms.entity.ticket.TicketExample;
import java.util.List;

import com.kaishengit.tms.entity.ticket.TicketOutRecord;
import org.apache.ibatis.annotations.Param;

public interface TicketMapper {
    long countByExample(TicketExample example);

    int deleteByExample(TicketExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    List<Ticket> selectByExample(TicketExample example);

    Ticket selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Ticket record, @Param("example") TicketExample example);

    int updateByExample(@Param("record") Ticket record, @Param("example") TicketExample example);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);

    /**
     *@描述 根据list批量插入Ticket
     *@参数:[ticketList]
     *@返回值void
     */
    void batchInsert(List<Ticket> ticketList);
    /**
     *@描述:根据起始票号查询有没有状态不是已入库的年票
     *@参数:[startTicketNum, endTicketNum, ticketStateInStore]
     *@返回值java.util.List<com.kaishengit.tms.entity.ticket.TicketOutRecord>
     */
    List<TicketOutRecord> findOutRecordBetweenStartAndEndNum(@Param("start") String startTicketNum, @Param("end") String endTicketNum, @Param("status") String ticketStateInStore);

    /**
     *@描述:查处年票中最大的年票号码
     *@参数:[]
     *@返回值Integer 返回值为现存年票的最大票号
     */
    Integer findMaxNumInTicket();
}