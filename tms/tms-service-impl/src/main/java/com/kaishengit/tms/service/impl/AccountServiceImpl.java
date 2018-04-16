package com.kaishengit.tms.service.impl;

import com.kaishengit.tms.entity.*;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.mapper.AccountLoginLogMapper;
import com.kaishengit.tms.mapper.AccountMapper;
import com.kaishengit.tms.mapper.AccountRolesMapper;
import com.kaishengit.tms.service.AccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 *@Description: AccountService接口的实现类
 *@Author: 邱志辉
 *@Date 2016/4/13 0013下午 2:52
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountLoginLogMapper accountLoginLogMapper;

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Value("${salt}")
    private String salt;

    @Autowired
    private AccountRolesMapper accountRolesMapper;

    /**
     * 描述:系统登录
     *
     * @param accountMobile
     * @param password
     * @param requestIp
     * @throws ServiceException 登录失败，抛出具体原因
     * @参数:accountMobile 手机号码
     * @参数:password 密码
     * @参数:requestIp 登录ip
     * @返回值com.kaishengit.tms.entity.Account 如果登录失败，该对象是null
     */
    @Override
    public Account login(String accountMobile, String password, String requestIp) {

        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andAccountMobileEqualTo(accountMobile);
        List<Account> accountList = accountMapper.selectByExample(accountExample);
        Account account = null;

        if(accountList != null && !accountList.isEmpty()){
            account = accountList.get(0);
            System.out.println(salt);
            if(password != null && DigestUtils.md5Hex(password + salt).equals(account.getAccountPassword())){
                if(Account.STATE_NORMAL.equals(account.getAccountStatus())){
                    AccountLoginLog accountLoginLog = new AccountLoginLog();
                    accountLoginLog.setAccountId(account.getId());
                    accountLoginLog.setLoginIp(requestIp);
                    accountLoginLog.setLoginTime(new Date());

                    accountLoginLogMapper.insertSelective(accountLoginLog);

                    logger.info("{}登录系统",account);

                }else if(Account.STATE_LOCKED.equals(account.getAccountStatus())){
                    throw new ServiceException("帐号已锁定");

                } else {
                    throw new ServiceException("帐号被禁用");
                }

            }else {
                throw new ServiceException("帐号密码错误");
            }

        }else{
            throw new ServiceException("帐号或密码错误");
        }

        return null;
    }

    /**
     * 描述:查找所有account
     *
     * @参数:[]
     * @返回值java.util.List<com.kaishengit.tms.entity.Account>
     */
    @Override
    public List<Account> findAllAccounts() {
        AccountExample accountExample = new AccountExample();
        return accountMapper.selectByExample(accountExample);
    }

    /**
     * 描述:查询所有account以及他们的角色
     *
     * @参数:[]
     * @返回值java.util.List<com.kaishengit.tms.entity.Account>
     */
    @Override
    public List<Account> findAllAccountsWithRoles() {
        System.out.println(salt);
        return accountMapper.findAllAccountWithRoles();

    }

    /**
     * 描述:保存account以及帐号角色关联关系
     *
     * @param account
     * @param rolesIds
     * @参数:[account, rolesId]
     * @返回值void
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveAccount(Account account, Integer[] rolesIds) {
        System.out.println(account);
        //电话后六位设为密码
        String accountMobile = account.getAccountMobile();
        System.out.println((accountMobile.length()-Account.MOBILE_LAST_SIX_NUMBER) + "...........");
        String password = accountMobile.substring(accountMobile.length()-Account.MOBILE_LAST_SIX_NUMBER);

        account.setAccountPassword(DigestUtils.md5Hex(password + salt));

        //初始状态为正常
        account.setAccountStatus(Account.STATE_NORMAL);
        //设置更新时间
        account.setUpdateTime(new Date());

        //有选择的插入account如果有属性为null则不插入
        accountMapper.insertSelective(account);

        //添加帐号和角色对应的关系
        AccountRolesExample accountRolesExample = new AccountRolesExample();
        if(rolesIds != null) {
            for (Integer roleId : rolesIds) {
                AccountRolesKey accountRolesKey = new AccountRolesKey();
                accountRolesKey.setAccountId(account.getId());
                accountRolesKey.setRolesId(roleId);
                accountRolesMapper.insert(accountRolesKey);
            }
        }

        logger.info("新增帐号,{}",account);
    }
}

/*+
class  test{
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5Hex("123#$#$%$%$"));
    }
}*/
