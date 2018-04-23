package com.kaishengit.tms.mapper.base;

import com.kaishengit.tms.entity.base.TicketOfficeAccount;
import com.kaishengit.tms.entity.base.TicketOfficeAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TicketOfficeAccountMapper {
    long countByExample(TicketOfficeAccountExample example);

    int deleteByExample(TicketOfficeAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TicketOfficeAccount record);

    int insertSelective(TicketOfficeAccount record);

    List<TicketOfficeAccount> selectByExample(TicketOfficeAccountExample example);

    TicketOfficeAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TicketOfficeAccount record, @Param("example") TicketOfficeAccountExample example);

    int updateByExample(@Param("record") TicketOfficeAccount record, @Param("example") TicketOfficeAccountExample example);

    int updateByPrimaryKeySelective(TicketOfficeAccount record);

    int updateByPrimaryKey(TicketOfficeAccount record);
}