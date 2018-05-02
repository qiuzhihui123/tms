package com.kaishengit.tms.controller.manage;

import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.dto.ResultHandler;
import com.kaishengit.tms.entity.manage.Account;
import com.kaishengit.tms.entity.manage.Roles;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.service.AccountService;
import com.kaishengit.tms.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    *@描述： 查询所有帐号以及所拥有的角色
    *@参数:[nameMobile, roleId, model]
    *@返回值java.lang.String
    */
    @GetMapping
    public String home(@RequestParam(required = false) String nameMobile,
                       @RequestParam(required = false) Integer roleId,
                       @RequestParam(required = false,defaultValue = "1")  Integer p,
                       Model model){
       // List<Account> accountList =  accountService.findAllAccountsWithRoles();

        Map<String,Object>  paramMap = new HashMap<>();
        paramMap.put("nameMobile",nameMobile);
        paramMap.put("roleId",roleId);

        PageInfo<Account> pageInfo = accountService.findAccountWithRolesByParams(paramMap,p);
        List<Roles> rolesList = rolePermissionService.findAllRoles();
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("rolesList",rolesList);

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

    /**
     * @描述:编辑account
     * @参数:[id(需要编辑的account对象的id)]
     * @返回值java.lang.String 编辑页面
     */
    @GetMapping("/{id:\\d+}/edit")
    public String newAccount(@PathVariable(required = false) Integer id,Model model) {
        List<Roles> rolesList = rolePermissionService.findAllRolesWithPermission();

        //找找相应的account并封装它具有的角色在rolesList属性上
        Account account = accountService.findAccountWithRoles(id);
        
        model.addAttribute("account",account);
        model.addAttribute("rolesList",rolesList);
        return "manage/account/edit";
    }
    
    /** 
     *@描述:保存编辑后的Account对象
     *@参数:[]
     *@返回值java.lang.String
     */
    @PostMapping("/{id:\\d+}/edit")
    public String updateAccount(Account account,
                                @RequestParam(required = false) Integer[] roleIds,
                                RedirectAttributes redirectAttributes){
        try {
            accountService.updateAccountByAccountAndRoleIds(account, roleIds);
        }catch (ServiceException e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message",e.getMessage());
            return "redirect:/manage/account";
        }
        redirectAttributes.addFlashAttribute("message","更新成功");
        return "redirect:/manage/account";
    }

    /**
     *@描述:根据accountId 删除相应的account以及它关联表
     *@参数:[id]
     *@返回值com.kaishengit.tms.dto.ResultHandler
     */
    @GetMapping("/{id:\\d+}/del")
    public @ResponseBody ResultHandler accountDel(@PathVariable Integer id){
        accountService.delAccountById(id);
        return ResultHandler.success();
    }

}
