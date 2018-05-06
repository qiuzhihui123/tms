package com.kaishengit.tms.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.entity.base.OfficeAccountLoginLog;
import com.kaishengit.tms.entity.base.TicketOfficeAccount;
import com.kaishengit.tms.entity.base.TicketOfficeInfermation;
import com.kaishengit.tms.entity.manage.Account;

import java.util.List;
import java.util.Map;

/**
 *@Description:关于售票点的service接口
 *@Author: 邱志辉
 *@Date 2016/4/19 0019下午 4:39
 */
public interface TicketOfficeService {

    /**
     *@描述: 查询出所有的售票点对象返回
     *@参数:[]
     *@返回值java.util.List<com.kaishengit.tms.entity.TicketOfficeInfermation> 售票点的List集合
     */
    List<TicketOfficeInfermation> findAllTicketOffices();

    /** 
     *@描述: 根据售票点信息对象创建售票点并创建售票点帐号
     *@参数:[ticketOfficeInfermation]
     *@返回值void
     */
    void addATicketOffice(TicketOfficeInfermation ticketOfficeInfermation);

    /**
     *@描述:根据售票点的id查找售票点对象以及它对应的account
     *@参数:[id] 售票点的id
     *@返回值com.kaishengit.tms.entity.base.TicketOfficeInfermation 售票点对象
     */
    TicketOfficeInfermation findOfficeWithAccountByOfficeId(Integer id);

   /**
    *@描述: 根据新的售票点对象更新该对象
    *@参数:[ticketOfficeInfermation] 新的售票点对象
    *@返回值void
    */
    void updateOfficeAndAccountByOfficeId(TicketOfficeInfermation ticketOfficeInfermation);

    /**
     *@描述:根据售票点id删除售票点相关
     *@参数:[id] 售票点id
     *@返回值void
     */
    void deleteOfficeByOfficeId(Integer id);

    /** 
     *@描述:根据id禁用销售点帐号
     *@参数:[id]
     *@返回值void
     */
    void forbiddenOfficeAccountById(Integer id);

    
    /** 
     *@描述:根据售票点电话找到对应的售票点信息
     *@参数:[accountMobile]
     *@返回值com.kaishengit.tms.entity.base.TicketOfficeInfermation
     */
    TicketOfficeInfermation findOfficeByAccountMobile(String accountMobile);

    /**
     *@描述:根据电话查找对应的销售点帐号
     *@参数:[accountMobile]
     *@返回值com.kaishengit.tms.entity.base.TicketOfficeAccount
     */
    TicketOfficeAccount findOfficeAccountByMobile(String accountMobile);

    /** 
     *@描述:根据页码和条件查询对应的销售点集合
     *@参数:[p, paramMap]
     *@返回值com.github.pagehelper.PageInfo<com.kaishengit.tms.entity.base.TicketOfficeInfermation>
     */
    PageInfo<TicketOfficeInfermation> findOfficesByParamsMap(Integer p, Map<String, Object> paramMap);

    /**
     *@描述:根据登录记录对象保存该相应帐号的登录记录
     *@参数:[officeAccountLoginLog]
     *@返回值void
     */
    void addLoginLog(OfficeAccountLoginLog officeAccountLoginLog);
}
