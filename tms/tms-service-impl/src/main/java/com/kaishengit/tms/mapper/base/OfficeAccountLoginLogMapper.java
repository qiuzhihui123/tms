package com.kaishengit.tms.mapper.base;

import com.kaishengit.tms.entity.base.OfficeAccountLoginLog;
import com.kaishengit.tms.entity.base.OfficeAccountLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfficeAccountLoginLogMapper {
    long countByExample(OfficeAccountLoginLogExample example);

    int deleteByExample(OfficeAccountLoginLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OfficeAccountLoginLog record);

    int insertSelective(OfficeAccountLoginLog record);

    List<OfficeAccountLoginLog> selectByExample(OfficeAccountLoginLogExample example);

    OfficeAccountLoginLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OfficeAccountLoginLog record, @Param("example") OfficeAccountLoginLogExample example);

    int updateByExample(@Param("record") OfficeAccountLoginLog record, @Param("example") OfficeAccountLoginLogExample example);

    int updateByPrimaryKeySelective(OfficeAccountLoginLog record);

    int updateByPrimaryKey(OfficeAccountLoginLog record);
}