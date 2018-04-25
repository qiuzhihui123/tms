package com.kaishengit.tms.mapper.ticket;

import com.kaishengit.tms.entity.ticket.TicketOutRecord;
import com.kaishengit.tms.entity.ticket.TicketOutRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TicketOutRecordMapper {
    long countByExample(TicketOutRecordExample example);

    int deleteByExample(TicketOutRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TicketOutRecord record);

    int insertSelective(TicketOutRecord record);

    List<TicketOutRecord> selectByExample(TicketOutRecordExample example);

    TicketOutRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TicketOutRecord record, @Param("example") TicketOutRecordExample example);

    int updateByExample(@Param("record") TicketOutRecord record, @Param("example") TicketOutRecordExample example);

    int updateByPrimaryKeySelective(TicketOutRecord record);

    int updateByPrimaryKey(TicketOutRecord record);

    /**
     *@描述:根据起始票号查询有没有状态不是已入库的年票
     *@参数:[startTicketNum, endTicketNum, ticketStateInStore]
     *@返回值java.util.List<com.kaishengit.tms.entity.ticket.TicketOutRecord>
     */
    List<TicketOutRecord> findOutRecordBetweenStartAndEndNum(@Param("start") String startTicketNum, @Param("end") String endTicketNum, @Param("status") String ticketStateInStore);

}