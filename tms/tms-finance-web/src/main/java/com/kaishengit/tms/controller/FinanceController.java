package com.kaishengit.tms.controller;

import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.entity.ticket.TicketOutRecord;
import com.kaishengit.tms.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;

/**
 *@Description:关于财务结算，例如售票点缴费等
 *@Author: 邱志辉
 *@Date 2016/4/24 0024下午 11:14
 */
@Controller
@RequestMapping("/finance")
public class FinanceController {
    @Autowired
    private TicketService ticketService;

    /**
     *@描述:根据当前页码显示现存的支付的和未支付的下发记录
     *@参数:[p,当前页码;model]
     *@返回值java.lang.String
     */
    @GetMapping("/office")
    public String home(@RequestParam(required = false,defaultValue = "1") Integer p,
                       @RequestParam(required = false)String status,
                       Model model){

        PageInfo<TicketOutRecord> pageInfo = ticketService.findAllTicketOutRecordByPage(p,status);
        model.addAttribute("pageInfo",pageInfo);
        return "finance/office/home";
    }

    /**
     *@描述:根据id查找相应的下发记录，跳转到付款页面
     *@参数:[id, model]
     *@返回值java.lang.String
     */
    @GetMapping("/office/{id:\\d+}/pay")
    public String officePay(@PathVariable(required = false) Integer id,Model model){
        TicketOutRecord ticketOutRecord = ticketService.findTIcketOutRecordById(id);
        model.addAttribute("ticketOutRecord",ticketOutRecord);
        return "finance/office/pay";
    }

    /** 
     *@描述:接收已付款的下发记录，并录入数据库，修改相关数据
     *@参数:[ticketOutRecord,下发记录;redirectAttributes重定向传值]
     *@返回值java.lang.String
     */
    @PostMapping("/office/{id:\\d+}/pay")
    public String officePaid(TicketOutRecord ticketOutRecord, RedirectAttributes redirectAttributes){

        ticketService.ticketInByRecordPaid(ticketOutRecord);

        redirectAttributes.addFlashAttribute("","");
        return "redirect:/finance/office";
    }

}
