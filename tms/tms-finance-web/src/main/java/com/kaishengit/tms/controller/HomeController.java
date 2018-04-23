package com.kaishengit.tms.controller;

import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.entity.ticket.Ticket;
import com.kaishengit.tms.service.AccountService;
import com.kaishengit.tms.service.TicketService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 *@Description: 首页以及登录登出
 *@Author: 邱志辉
 *@Date 2016/4/22 0022下午 8:24
 */
@Controller
public class HomeController {

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private AccountService accountService;
    @Autowired
    private TicketService ticketService;
    @Value("${salt}")
    private String salt;

    /**
     *@描述:系统登录页面
     *@参数:[]
     *@返回值java.lang.String
     */
    @GetMapping("/")
    public String home(){
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
     *描述:系统登录
     */
    @PostMapping("/")
    public String login(String accountMobile,
                        String password,
                        String remember,
                        HttpServletRequest req,
                        HttpServletResponse resp,
                        HttpSession session,
                        RedirectAttributes redirectAttributes){

        //创建subject
        Subject subject = SecurityUtils.getSubject();
        //获得登录ip
        String requestIp = req.getRemoteAddr();
        //根据帐号密码验证登录
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(accountMobile,
                DigestUtils.md5Hex(password + salt),
                remember != null,
                requestIp);

        try{
            subject.login(usernamePasswordToken);

            if(subject.hasRole("finance") || subject.hasRole("repository")){
                //登录后跳转的url
                SavedRequest savedRequest = new SavedRequest(req);

                String url = "/home";
                /*if(subject.hasRole("repository")){
                    url = "/ticket/repository/home";
                }
                if(subject.hasRole("finance")){
                    url = "/ticket/finance/home";
                }*/
                if(savedRequest != null){
                    url = savedRequest.getRequestUrl();
                }
                return "redirect:"+url;

            }else{
                logger.info("{}没有权限登录该系统",accountMobile);
                redirectAttributes.addFlashAttribute("message","没有权限");
            }


        }catch (UnknownAccountException | IncorrectCredentialsException e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message","帐号或密码错误");
        }catch (LockedAccountException e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message","帐号被锁定");
        }catch (AuthenticationException e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message","帐号或密码错误");
        }
        return "redirect:/";

    }


    /**
     *@描述:跳转home页面
     *@参数:
     *@返回值
     */
    @GetMapping("/home")
    public String toHome(){
        return "home";
    }


    /**
     *@描述: 跳转错误页面
     *@参数:[]
     *@返回值java.lang.String
     */
    @GetMapping("/401")
    public String unauthorizedUrl(){
        return "error/401";
    }
}
