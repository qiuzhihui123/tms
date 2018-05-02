package com.kaishengit.tms.shiro;

import com.kaishengit.tms.entity.base.TicketOfficeAccount;
import com.kaishengit.tms.entity.base.TicketOfficeInfermation;
import com.kaishengit.tms.entity.manage.Account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

@Component
public class ShiroUtil {

    public static TicketOfficeInfermation getCurrentAccount(){
        Subject subject = SecurityUtils.getSubject();
        return (TicketOfficeInfermation) subject.getPrincipal();
    }

}
