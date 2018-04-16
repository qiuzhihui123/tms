package com.kaishengit.tms.controller;

import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.entity.Roles;
import com.kaishengit.tms.mapper.AccountMapper;
import com.kaishengit.tms.service.AccountService;
import com.kaishengit.tms.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/manage/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private RolePermissionService rolePermissionService;
    @Value("${salt}")
    private  String salt;

    /**
     *描述:查找所有帐号以及拥有的角色
     *@参数:[]
     *@返回值java.lang.String
     */
    @GetMapping
    public String home(Model model){
        List<Account> accountList =  accountService.findAllAccountsWithRoles();
        model.addAttribute("accountList",accountList);
        System.out.println(salt);
        return "manage/account/home";
    }

    @GetMapping("/new")
    public String newAccount(Model model){
        List<Roles> rolesList = rolePermissionService.findAllRolesWithPermission();
        model.addAttribute("rolesList",rolesList);

        return "manage/account/new";
    }
    /**
     *描述:保存account
     *@参数:[]
     *@返回值java.lang.String
     */
    @PostMapping("/new")
    public String saveAccount(Account account, @RequestParam(required = false) Integer[] roleIds, RedirectAttributes redirectAttributes){
        //System.out.println(roleIds);
        accountService.saveAccount(account,roleIds);

        redirectAttributes.addFlashAttribute("message","保存成功");
        return "redirect:/manage/account";
    }

}
