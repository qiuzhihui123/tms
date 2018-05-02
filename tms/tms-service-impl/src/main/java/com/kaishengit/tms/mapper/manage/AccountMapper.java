package com.kaishengit.tms.mapper.manage;

import com.kaishengit.tms.entity.manage.Account;
import com.kaishengit.tms.entity.manage.AccountExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    long countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    List<Account> findAllAccountWithRoles();

    Account findAccountWithRoles(Integer id);

    /**
     *@描述:根据条件查询符合条件的account并带有roles集合
     *@参数:[paramMap]
     *@返回值java.util.List<com.kaishengit.tms.entity.manage.Account>
     */
    List<Account> findAccountWithRolesByParams(Map<String, Object> paramMap);
}