package com.kaishengit.tms.mapper.base;

import com.kaishengit.tms.entity.base.TicketOfficeInfermation;
import com.kaishengit.tms.entity.base.TicketOfficeInfermationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TicketOfficeInfermationMapper {
    long countByExample(TicketOfficeInfermationExample example);

    int deleteByExample(TicketOfficeInfermationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TicketOfficeInfermation record);

    int insertSelective(TicketOfficeInfermation record);

    List<TicketOfficeInfermation> selectByExample(TicketOfficeInfermationExample example);

    TicketOfficeInfermation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TicketOfficeInfermation record, @Param("example") TicketOfficeInfermationExample example);

    int updateByExample(@Param("record") TicketOfficeInfermation record, @Param("example") TicketOfficeInfermationExample example);

    int updateByPrimaryKeySelective(TicketOfficeInfermation record);

    int updateByPrimaryKey(TicketOfficeInfermation record);

    TicketOfficeInfermation findOfficeWithAccountByOfficeId(Integer id);
}