package com.kaishengit.tms.controller;

import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.dto.ResultHandler;
import com.kaishengit.tms.entity.base.TicketOfficeInfermation;
import com.kaishengit.tms.entity.ticket.TicketInRecord;
import com.kaishengit.tms.entity.ticket.TicketOutRecord;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.service.TicketOfficeService;
import com.kaishengit.tms.service.TicketService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

/**
 *@Description: 年票的库存管理，财务结算
 *@Author: 邱志辉
 *@Date 2016/4/22 0022下午 8:22
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketOfficeService ticketOfficeService;

    /**
     *@描述: 年票入库主页
     *@参数:[p, model]
     *@返回值java.lang.String
     */
    @GetMapping("/repository/in")
    public String ticketInHome(@RequestParam(required = false,defaultValue = "1") Integer p,Model model){

        PageInfo<TicketInRecord> pageInfo = ticketService.findAllTicketSRecordByPage(p);
        model.addAttribute("pageInfo",pageInfo);
        return "ticket/repository/in/home";
    }

    /**
     *@描述:新增年票入库
     *@参数:
     *@返回值
     */
    @GetMapping("/repository/in/new")
    public String repositoryInNew(Model model){
        String now = DateTime.now().toString("YYYY-MM-dd");
        model.addAttribute("now",now);
        return "ticket/repository/in/new";
    }

    /**
     *@描述:保存年票录入记录，并录入相应的年票
     *@参数:[ticketInRecord, redirectAttributes]
     *@返回值java.lang.String
     */
    @PostMapping("/repository/in/new")
    public String saveTicketInRecord(TicketInRecord ticketInRecord,
                                     RedirectAttributes redirectAttributes){
        try {
            ticketService.ticketInByRecord(ticketInRecord);
        }catch (ServiceException e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message",e.getMessage());
            return "redirect:/ticket/repository/in";
        }
        redirectAttributes.addFlashAttribute("message","保存成功");
        return "redirect:/ticket/repository/in";
    }

    /**
     *@描述:跳转年票下发的主页面，显示下发的记录
     *@参数:[p,当前页码; model，传值对象]
     *@返回值java.lang.String
     */
    @GetMapping("/repository/out")
    public String ticketOutHome(@RequestParam(required = false,defaultValue = "1") Integer p,Model model){

        PageInfo<TicketOutRecord> pageInfo = ticketService.findAllTicketOutRecordByPage(p);
        model.addAttribute("pageInfo",pageInfo);
        return "ticket/repository/out/home";
    }

    /**
     *@描述:携带当前时间跳转新增下发页面
     *@参数:[model] 携带数据对象
     *@返回值java.lang.String
     */
    @GetMapping("/repository/out/new")
    public String ticketOutNew(Model model){
        List<TicketOfficeInfermation> officeList = ticketOfficeService.findAllTicketOffices();
        String now = DateTime.now().toString("YYYY-MM-dd");

        model.addAttribute("officeList",officeList);
        model.addAttribute("now",now);

        return "ticket/repository/out/new";
    }

    /**
     *@描述:根据接收的表单值封装的信息新增下发记录
     *@参数:[]
     *@返回值java.lang.String
     */
    @PostMapping("/repository/out/new")
    public String ticekeOutNewSave(TicketOutRecord ticketOutRecord,RedirectAttributes redirectAttributes){

    try {
        ticketService.ticketOutRecordNew(ticketOutRecord);
    }catch (ServiceException e){
        e.printStackTrace();
        redirectAttributes.addFlashAttribute("errorMessage",e.getMessage());
        return"redirect:/ticket/repository/out";

    }
        redirectAttributes.addFlashAttribute("message","新增成功");
        return"redirect:/ticket/repository/out";
    }

    @GetMapping("/repository/out/{id:\\d+}/del")
    public @ResponseBody
    ResultHandler outRecordDel(@PathVariable Integer id){


        return  ResultHandler.success();
    }


}
