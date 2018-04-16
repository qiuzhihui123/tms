package com.kaishengit.tms.service;

import com.kaishengit.tms.entity.Account;

import java.util.List;

/**
 *@Description:系统帐号的业务接口
 *@Author: 邱志辉
 *@Date 2016/4/13 0013下午 3:00
 */
public interface AccountService {
    /** 
     *描述:系统登录
     *
     *@参数:accountMobile 手机号码
     *@参数:password 密码
     *@参数:requestIp 登录ip
     *@返回值com.kaishengit.tms.entity.Account 如果登录失败，该对象是null
     * @throws com.kaishengit.tms.exception.ServiceException 登录失败，抛出具体原因
     */
    Account login(String accountMobile, String password, String requestIp);

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
}
