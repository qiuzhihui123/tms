package com.kaishengit.tms.controller;


import com.kaishengit.tms.dto.ResultHandler;
import com.kaishengit.tms.entity.base.Customer;
import com.kaishengit.tms.entity.base.TicketOfficeInfermation;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.filesRepository.FastDfsUtil;
import com.kaishengit.tms.service.TicketService;
import com.kaishengit.tms.shiro.ShiroUtil;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

/**
 *@Description:年票销售，挂失，补办等相关
 *@Author: 邱志辉
 *@Date 2016/4/27 0027下午 12:59
 */
@Controller
@RequestMapping("/sale/ticket")
public class SaleController {

    @Autowired
    private FastDfsUtil fastDfsUtil;

    @Autowired
    private TicketService ticketService;

    /**
     *@描述:跳转年票开卡页面
     *@参数:[]
     *@返回值java.lang.String
     */
    @GetMapping("/new")
    public String saleNew(){
        return"ticket/new";
    }

    /**
     *@描述:根据顾客，年票号码，价格等数据保存该顾客开卡记录
     *@参数:[customer, ticketNum, ticketPrice, redirectAttributes]
     *@返回值java.lang.String
     */
    @PostMapping("/new")
    public String saleSave(Customer customer,
                           @RequestParam(name = "ticketNum")String ticketNum,
                           BigDecimal ticketPrice,
                           RedirectAttributes redirectAttributes){
        //获取当前登录的售票点
        TicketOfficeInfermation office  = ShiroUtil.getCurrentAccount();
        try{
            //保存顾客的开开记录
            ticketService.saveCustomerWithTicket(customer,ticketNum,ticketPrice,office);
            redirectAttributes.addFlashAttribute("message","保存成功");
        }catch (ServiceException e){
            redirectAttributes.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/sale/ticket/new";
    }



    @PostMapping("/upload")
    public @ResponseBody
    ResultHandler upload(@RequestParam MultipartFile file) throws IOException, MyException {

        try {
            InputStream input = file.getInputStream();
            String fileName = file.getOriginalFilename();

            String extName = fileName.substring(fileName.lastIndexOf(".") + 1);

            String location = fastDfsUtil.uploadFile(input, extName);
            return ResultHandler.success(location);
        }catch (IOException | MyException e){
            return ResultHandler.error("服务器异常");
        }
    }

}
