package com.kaishengit.tms.shiro;

import com.kaishengit.tms.entity.manage.Account;
import com.kaishengit.tms.entity.manage.Permission;
import com.kaishengit.tms.entity.manage.Roles;
import com.kaishengit.tms.service.AccountService;
import com.kaishengit.tms.service.RolePermissionService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MyShiroRealm extends AuthorizingRealm{
    @Autowired
    private AccountService accountService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Value("${salt}")
    private String salt;

    private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       Account account = (Account) principalCollection.getPrimaryPrincipal();
       //查找当前account所拥有的角色
        List<Roles> rolesList = rolePermissionService.findAccountRolesByAccountId(account.getId());

        List<Permission> permissionList = new ArrayList<>();

        Set<String> rolesName = new HashSet<>();

        for (Roles role : rolesList){
            rolesName.add(role.getRolesCode());
            List<Permission> rolePermissionList = rolePermissionService.findRolesWithPermissionById(role.getId()).getPermissionList();
            permissionList.addAll(rolePermissionList);
        }

       Set<String> permissionNames = new HashSet<>();
        for(Permission permission : permissionList){
            permissionNames.add(permission.getPermissionCode());
        }

        SimpleAuthorizationInfo  simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissionNames);
        simpleAuthorizationInfo.setRoles(rolesName);
        System.out.println("---------------------------------");

       return simpleAuthorizationInfo;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String accountMobile = usernamePasswordToken.getUsername();
        String requestIp = usernamePasswordToken.getHost();
        System.out.println(salt);
        if(accountMobile != null){
            Account account = accountService.findAccountByMobile(accountMobile);
            if(account == null){
                throw new UnknownAccountException("找不到该帐号" + accountMobile);
            }else {
                if(Account.STATE_NORMAL.equals(account.getAccountStatus())){
                    logger.info("登录成功,{}",account);
                    accountService.addLoginLog(account,requestIp);
                    return new SimpleAuthenticationInfo(account, account.getAccountPassword(),getName());
                }else {
                    throw new LockedAccountException("帐号被锁定或禁用"+ account);
                }
            }
        }
        return null;

    }
}
