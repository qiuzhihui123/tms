package com.kaishengit.tms.controller;

import com.kaishengit.tms.entity.base.TicketOfficeInfermation;
import com.kaishengit.tms.service.TicketService;
import com.kaishengit.tms.shiro.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *@Description:首页及系统登录登
 *@Author:邱志辉
 *@Date 2016/4/27 0027上午 8:54
 */
@Controller
public class HomeController {

    @Autowired
    private TicketService ticketService;

    /**
     *@描述:判断帐号登录状态，跳转登录页面
     *@参数:[]
     *@返回值java.lang.String
     */
    @GetMapping("/")
    public String index(){

        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            subject.logout();
        }

        if(subject.isRemembered()){
            return "redirect:/home";
        }

        return "index";
    }


    /**
     *@描述:根据前端提交的信息验证登录
     *@参数:[accountMobile, password, remember, request, redirectAttributes]
     *@返回值java.lang.String
     */
    @PostMapping("/")
    public String login(String accountMobile,
                        String password,
                        String remember,
                        HttpServletRequest request,
                        RedirectAttributes redirectAttributes){

        Subject subject = SecurityUtils.getSubject();
        //获得ip
        String requestIp = request.getRemoteAddr();

        //创建验证对象
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(accountMobile,
                                                        password,
                                                        remember!=null
                                                        ,requestIp);
            //用usernamepassword登录,登录失败会抛异常
        try {
            subject.login(usernamePasswordToken);

            //登录后跳转网址
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            String url = "/home";
            if(savedRequest != null){
                url = savedRequest.getRequestUrl();
            }

            return "redirect:"+url;

        }catch (UnknownAccountException | IncorrectCredentialsException e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("mesage","帐号密码错误");
        }catch (LockedAccountException e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message","帐号被锁定");
        }catch (AuthenticationException e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message","帐号密码错误");
        }

        return "redirect:/";

    }
    
    /** 
     *@描述: 查询出该销售点的销售情况，显示到home页面
     *@参数:[model]
     *@返回值java.lang.String
     */
    @GetMapping("/home")
    public  String home(Model model){

        TicketOfficeInfermation ticketOfficeInfermation = ShiroUtil.getCurrentAccount();

        Map<String,Long> saleMap = ticketService.findChartsOfTicketOfOneOfficeByOfficeId(ticketOfficeInfermation.getId());
        model.addAttribute("saleMap",saleMap);
        return"home";
    }


}
