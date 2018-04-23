package com.kaishengit.tms.controller.Base;


import com.kaishengit.tms.dto.ResultHandler;
import com.kaishengit.tms.entity.base.TicketOfficeInfermation;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.service.TicketOfficeService;
import com.kaishengit.tms.util.QiNiuCloudTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


/**
 *@Description:关于售票点的controller
 *@Author: 邱志辉
 *@Date 2016/4/19 0019下午 4:23
 */
@Controller
@RequestMapping("/base/office")
public class TicketOfficeController {


    @Autowired
    TicketOfficeService ticketOfficeService;
    @Autowired
    QiNiuCloudTokenUtil qiNiuCloudTokenUtil;

    /**
     *@描述:访问售票点目录
     *@参数:[model] 访问目录的传值对象，装有售票点List
     *@返回值java.lang.String
     */
    @GetMapping
    public  String home(Model model){

        List<TicketOfficeInfermation> officeList = ticketOfficeService.findAllTicketOffices();

        model.addAttribute("officeList",officeList);
        return "base/office/home";
    }


    /**
     *@描述:请求转发到新增售票点的页面
     *@参数:[model] 传值对象带有 uploadToken
     *@返回值java.lang.String
     */
    @GetMapping("/new")
    public String newOffice(Model model){
        model.addAttribute("token", qiNiuCloudTokenUtil.getToken());
        return "base/office/new";
    }

    /**
     *@描述: 接收提交的售票点信息并存到数据库，并根据这个对象录入售票点信息并创建售票点帐号
     *@参数:[ticketOfficeInfermation] 售票点信息对象
     *@返回值java.lang.String
     */
    @PostMapping("/new")
    public String saveOffice(TicketOfficeInfermation ticketOfficeInfermation,
                             RedirectAttributes redirectAttributes){
        ticketOfficeService.addATicketOffice(ticketOfficeInfermation);
        redirectAttributes.addFlashAttribute("message","储存成功");
        return "redirect:/base/office";
    }

    /**
     *@描述:根据传过来的id查找到对应的售票点以及它关联的Account对象返回
     *@参数:[id, model] 售票点的id，传参的model对象
     *@返回值java.lang.String
     */
    @GetMapping("/{id:\\d+}/detail")
    public String toDetail(@PathVariable Integer id,Model model){
        TicketOfficeInfermation office = ticketOfficeService.findOfficeWithAccountByOfficeId(id);
        model.addAttribute("office",office);
        return "base/office/detail";
    }

    /**
     *@描述:根据传过来的 售票点id 找到该售票点并跳转到编辑页面
     *@参数:[id,售票点id;model传值对象]
     *@返回值java.lang.String
     */
    @GetMapping("/{id:\\d+}/edit")
    public String officeEdit(@PathVariable Integer id,Model model){
        TicketOfficeInfermation office = ticketOfficeService.findOfficeWithAccountByOfficeId(id);
        String token = qiNiuCloudTokenUtil.getToken();
        model.addAttribute("token",token);
        model.addAttribute("office",office);
        return "base/office/edit";
    }

    /**
     *@描述: 根据解析出的售票点对象更新对应id的售票点
     *@参数:[officeId, ticketOfficeInfermation, redirectAttributes]
     *@返回值java.lang.String
     */
    @PostMapping("/{id:\\d+}/edit")
    public  String officeUpdate(@PathVariable(name = "id",required = false) Integer officeId,
                                TicketOfficeInfermation ticketOfficeInfermation,
                                RedirectAttributes redirectAttributes){
        try {
            ticketOfficeService.updateOfficeAndAccountByOfficeId(ticketOfficeInfermation);
        }catch (ServiceException e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message","更新失败，请稍后再试");
            return "redirect:/base/office"+officeId+"/detail";
        }
        redirectAttributes.addFlashAttribute("message","更新成功");
        return "redirect:/base/office/"+officeId+"/detail";
    }

    /**
     *@描述: 根据异步请求传过来的售票点id进行删除售票点的相关操作，并返回json数据
     *@参数:[id]
     *@返回值com.kaishengit.tms.dto.ResultHandler
     */
    @GetMapping("/{id:\\d+}/del")
    public @ResponseBody ResultHandler officeDel(@PathVariable Integer id){

        ticketOfficeService.deleteOfficeByOfficeId(id);

        return ResultHandler.success();
    }

    /**
     *@描述:根据id禁用销售点帐号
     *@参数:[id]
     *@返回值com.kaishengit.tms.dto.ResultHandler json数据
     */
    @GetMapping("/{id:\\d+}/forbidden")
    public @ResponseBody ResultHandler oficeAccountForbidden(@PathVariable Integer id){
        ticketOfficeService.forbiddenOfficeAccountById(id);

        return ResultHandler.success();
    }


}


