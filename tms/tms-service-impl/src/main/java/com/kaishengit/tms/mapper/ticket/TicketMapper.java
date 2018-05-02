package com.kaishengit.tms.mapper.ticket;

import com.kaishengit.tms.entity.ticket.Ticket;
import com.kaishengit.tms.entity.ticket.TicketExample;
import java.util.List;
import java.util.Map;

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
     *@描述:查处年票中最大的年票号码
     *@参数:[]
     *@返回值Integer 返回值为现存年票的最大票号
     */
    Integer findMaxNumInTicket();

    /**
     *@描述:根据起始票号查询年票集合
     *@参数:[startTicketNum, endTicketNum]
     *@返回值java.util.List<com.kaishengit.tms.entity.ticket.Ticket>
     */
    List<Ticket> selectTicketsByStartAndEndNum(@Param("start") String startTicketNum, @Param("end") String endTicketNum,@Param("status") String status);

    /**
     *@描述:根据需要删除的id的list集合删除相应的年票
     *@参数:[ticketIds]
     *@返回值void
     */
    void batchDeleteByIdList(List<Long> ticketIds);

    /**
     *@描述:查找相应状态的年票数量
     *@参数:[]
     *@返回值java.lang.Integer
     */
    Map<String,Long> countByStatus();


    /**
     *@描述:根据销售点id查询该销售年票的统计
     *@参数:[id]
     *@返回值java.util.Map<java.lang.String,java.lang.Long>
     */
    Map<String,Long> findSaleCountByOfficeId(Integer id);


}