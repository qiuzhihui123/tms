package com.kaishengit.tms.controller;

import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.service.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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



    /** 
     *描述:系统登录页面
     */
    @GetMapping("/")
    public  String home(@CookieValue(required = false) String account,Model model){
        if(StringUtils.isNotEmpty(account)) {
            model.addAttribute("account", account);
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

        if(StringUtils.isNotEmpty(remember)){
            Cookie cookie = new Cookie("account",accountMobile);
            cookie.setDomain("localhost");
            cookie.setPath("/");
            cookie.setMaxAge(60*60*24);
            resp.addCookie(cookie);
        }else {
            Cookie[] cookies = req.getCookies();
            for(Cookie cookie : cookies){
                if("account".equals(cookie.getName())){
                    cookie.setMaxAge(0);
                   resp.addCookie(cookie);
                }
            }
        }

        String requestIp = req.getRemoteAddr();
        try {
            Account acc = accountService.login(accountMobile, password, requestIp);
            session.setAttribute("currAccount",acc);
            return "redirect:/home";
        }catch (ServiceException e){
            redirectAttributes.addFlashAttribute("mobile",accountMobile);
            redirectAttributes.addFlashAttribute("message",e.getMessage());
            return "redirect:/";
        }

    }

    @GetMapping("/home")
    public String homePage(){

        return "home";
    }
}
