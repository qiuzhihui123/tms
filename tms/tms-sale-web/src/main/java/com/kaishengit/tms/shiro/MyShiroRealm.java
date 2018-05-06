package com.kaishengit.tms.shiro;

import com.kaishengit.tms.entity.base.OfficeAccountLoginLog;
import com.kaishengit.tms.entity.base.TicketOfficeAccount;
import com.kaishengit.tms.entity.base.TicketOfficeInfermation;
import com.kaishengit.tms.entity.manage.Account;
import com.kaishengit.tms.entity.manage.Permission;
import com.kaishengit.tms.entity.manage.Roles;
import com.kaishengit.tms.service.AccountService;
import com.kaishengit.tms.service.RolePermissionService;
import com.kaishengit.tms.service.TicketOfficeService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;


public class MyShiroRealm extends AuthorizingRealm{

    @Autowired
    private TicketOfficeService ticketOfficeService;


    @Value("${salt}")
    private String salt;

    private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
         return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //接收验证信息
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;

        String accountMobile = usernamePasswordToken.getUsername();

        String requestIp = usernamePasswordToken.getHost();


        if(accountMobile != null){
            //根据电话找到售票点信息对象
            TicketOfficeAccount ticketOfficeAccount = ticketOfficeService.findOfficeAccountByMobile(accountMobile);
            if(ticketOfficeAccount == null){
                throw new UnknownAccountException("找不到该帐号" + accountMobile);
            }else {
                if(TicketOfficeAccount.ACCOUNT_NOMAL_STATUS.equals(ticketOfficeAccount.getStatus())){

                    OfficeAccountLoginLog officeAccountLoginLog = new OfficeAccountLoginLog();
                    officeAccountLoginLog.setLoginIp(usernamePasswordToken.getHost());
                    officeAccountLoginLog.setLoginTime(new Date());
                    officeAccountLoginLog.setOfficeAccountId(ticketOfficeAccount.getId());

                    ticketOfficeService.addLoginLog(officeAccountLoginLog);
                    logger.info("{},登录成功");

                 TicketOfficeInfermation ticketOfficeInfermation = ticketOfficeService.findOfficeByAccountMobile(accountMobile);

                    return new SimpleAuthenticationInfo(ticketOfficeInfermation, ticketOfficeAccount.getTicketOfficeAccountPassword(),getName());
                }else{
                    throw new LockedAccountException("帐号被锁定或禁用"+ ticketOfficeAccount);
                }
            }
        }
        return null;

    }
}
