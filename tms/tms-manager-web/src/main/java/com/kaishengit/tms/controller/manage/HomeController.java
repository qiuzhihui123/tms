package com.kaishengit.tms.controller.manage;

import com.kaishengit.tms.service.AccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.*;

/**
 *@Description:首页以及登录登出
 *@Author: 邱志辉
 *@Date 2016/4/13 0013下午 2:15
 */
@Controller
public class HomeController {

    @Autowired
    private AccountService accountService;
    @Value("${salt}")
    private String salt;

    /**
     *描述:系统登录页面
     */
    @GetMapping("/")
    public  String home(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            subject.logout();
        }
        System.out.println("记住我"+subject.isRemembered());

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
        String requestIp = req.getRemoteAddr();
        //根据帐号密码验证登录
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(accountMobile,
                DigestUtils.md5Hex(password + salt),
                remember != null,
                requestIp);

        try{
            subject.login(usernamePasswordToken);

            return "redirect:/home";
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

    @GetMapping("/home")
    public String homePage(){

        return "home";
    }

    /*@GetMapping("/logout")
    public String logout(RedirectAttributes redirectAttributes){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        redirectAttributes.addFlashAttribute("message","退出成功");
        return "redirect:/";
    }*/


    @GetMapping("/401")
    public String unauthorizedUrl(){
        return "error/401";
    }
}
