package com.kaishengit.tms.shiro;

import com.kaishengit.tms.entity.manage.Account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

@Component
public class ShiroUtil {

    public static Account getCurrentAccount(){
        Subject subject = SecurityUtils.getSubject();
        return (Account) subject.getPrincipal();
    }

}
