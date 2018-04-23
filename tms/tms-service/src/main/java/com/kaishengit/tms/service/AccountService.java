package com.kaishengit.tms.service;

import com.kaishengit.tms.entity.manage.Account;

import java.util.List;

/**
 *@Description:系统帐号的业务接口
 *@Author: 邱志辉
 *@Date 2016/4/13 0013下午 3:00
 */
public interface AccountService {

      /**
     *描述:查找所有account
     *@参数:[]
     *@返回值java.util.List<com.kaishengit.tms.entity.Account>
     */
    List<Account> findAllAccounts();

    /** 
     *描述:查询所有account以及他们的角色
     *@参数:[]
     *@返回值java.util.List<com.kaishengit.tms.entity.Account>
     */
    List<Account> findAllAccountsWithRoles();

    /** 
     *描述:保存account以及帐号角色关联关系
     *@参数:[account, rolesId]
     *@返回值void
     */
    void saveAccount(Account account, Integer[] rolesId);

    /**
     *@描述:查找account并封装rolesList集合在相应属性上
     *@参数:[id(account的id)]
     *@返回值com.kaishengit.tms.entity.Account
     * @param id
     */
    Account findAccountWithRoles(Integer id);

    /**
     *@描述:根据mobile查找account对象
     *@参数:[accountMobile] mobile
     *@返回值com.kaishengit.tms.entity.Account account对象
     */
    Account findAccountByMobile(String accountMobile);

    /**
     *@描述: 根据登录的account以及ip记录登录日志
     *@参数:[account] 登录的account 以及登录的ip
     *@返回值void
     */
    void  addLoginLog(Account account, String requestIp);

    /**
     *@描述:根据account和roleIds更新 account以及对应的角色关系
     *@参数:[account, roleIds]
     *@返回值void
     */
    void updateAccountByAccountAndRoleIds(Account account, Integer[] roleIds);

    /**
     *@描述:根据accountId删除相应的accountId以及关联关系
     *@参数:[id] accountId
     *@返回值void
     */
    void delAccountById(Integer id);
}
