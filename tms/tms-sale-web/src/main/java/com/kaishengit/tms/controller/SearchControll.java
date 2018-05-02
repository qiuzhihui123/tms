package com.kaishengit.tms.controller;

import com.kaishengit.tms.entity.base.TicketOfficeInfermation;
import com.kaishengit.tms.entity.ticket.Ticket;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.service.TicketService;
import com.kaishengit.tms.shiro.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *@Description: 查找年票controller
 *@Author: 邱志辉
 *@Date 2016/5/1 0001下午 11:59
 */
@Controller
@RequestMapping("/search/ticket")
public class SearchControll {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public String home(){

        return "/ticket/search";
    }

    /**
     *@描述:根据卡号查询年票
     *@参数:[ticketNum, model]
     *@返回值java.lang.String
     */
    @PostMapping
    public String search(@RequestParam(required = false,defaultValue = "") String ticketNum,
                         Model model){
        try{
            TicketOfficeInfermation office = ShiroUtil.getCurrentAccount();
            Ticket ticket= ticketService.findTicketByTicketNum(ticketNum,office);
            model.addAttribute("ticket",ticket);
        }catch (ServiceException e){
            model.addAttribute("message",e.getMessage());
        }

        return "/ticket/search";
    }

}
