package com.kaishengit.tms.mapper.base;

import com.kaishengit.tms.entity.base.TicketOfficeInfermation;
import com.kaishengit.tms.entity.base.TicketOfficeInfermationExample;
import java.util.List;
import java.util.Map;
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

    /**
     *@描述:根据条件查找对应的销售点信息集合
     *@参数:[paramMap]
     *@返回值java.util.List<com.kaishengit.tms.entity.base.TicketOfficeInfermation>
     */
    List<TicketOfficeInfermation> findOfficesByParamsMap(Map<String, Object> paramMap);
}