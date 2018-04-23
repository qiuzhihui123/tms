package com.kaishengit.tms.controller.manage;

import com.kaishengit.tms.dto.ResultHandler;
import com.kaishengit.tms.entity.manage.Permission;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.service.RolePermissionService;
import com.kaishengit.tms.shiro.CustomerFilterChainDefinitions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 *@Description: 处理permission相关的controller
 *@Author: 邱志辉
 *@Date 2016/4/15 0015下午 7:55
 */
@Controller
@RequestMapping("/manage/permission")
public class PermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;
    @Autowired
    private  CustomerFilterChainDefinitions customerFilterChainDefinitions;

    /**
     *@Description: 展示permission列表
     *@Author: 邱志辉
     *@Date 2016/4/15 0015下午 7:56
     */
    @GetMapping
    public String home(Model model){
        List<Permission> permissionList = rolePermissionService.findAllPermissions();
        model.addAttribute("permissionList",permissionList);
        return "manage/permission/home";
    }

    /**
     *描述:新增权限
     *@参数:[model] 查询菜单类型列表放到model,回显到前端页面
     *@返回值java.lang.String
     */
    @GetMapping("/new")
    public String newPermission(Model model) {

        List<Permission> permissionList = rolePermissionService.findPermissionByPermissionType(Permission.MENU_TYPE);

        model.addAttribute("permissionList",permissionList);
        return "manage/permission/new";
    }

    /** 
     *描述:保存新增的权限管理
     *@参数:[permission（新增的permission对象）,
     * redirectAttributes（用于重定向信息传递的对象）]
     *@返回值java.lang.String
     */
    @PostMapping("/new")
    public String newPermission(Permission permission, RedirectAttributes redirectAttributes) {
        rolePermissionService.savePermission(permission);
        customerFilterChainDefinitions.update();
        redirectAttributes.addFlashAttribute("message","新增权限成功");
        return "redirect:/manage/permission";
    }

    /**
 *描述:根据id查找相应权限对象
 *@参数:[]
 *@返回值
 */
    @GetMapping("/{id:\\d+}/edit")
    public String edit(@PathVariable Integer id,Model model){
        Permission permission = rolePermissionService.findPermissionById(id);
        List<Permission> permissionList = rolePermissionService.findPermissionByPermissionType(Permission.MENU_TYPE);
        model.addAttribute("permissionList",permissionList);
        model.addAttribute("permission",permission);
        return "manage/permission/edit";
    }


    /**
     *@描述: 保存编辑后的permission，后返回permission列表
     *@参数: [permission,权限对象
     *  redirectAttributes 保存成功后携带通知前端信息的对象]
     *@返回值java.lang.String
     */
    @PostMapping("/{id:\\d+}/edit")
    public String edit(Permission permission,RedirectAttributes redirectAttributes){


        rolePermissionService.updatePermission(permission);
        customerFilterChainDefinitions.update();
        redirectAttributes.addFlashAttribute("message","保存成功");
        return "redirect:/manage/permission";
    }

    /** 
     *描述:根据id删除权限
     *@参数:[id]
     *@返回值com.kaishengit.tms.dto.ResultHandler
     */
    @GetMapping("/{id:\\d+}/del")
        public @ResponseBody ResultHandler del(@PathVariable Integer id){
        try{
            rolePermissionService.delPermissionById(id);
            customerFilterChainDefinitions.update();
            return ResultHandler.success();
        } catch (ServiceException e){
            return ResultHandler.error(e.getMessage());
        }


        }

}
