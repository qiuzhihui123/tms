package com.kaishengit.tms.controller.manage;


import com.google.common.collect.Maps;
import com.kaishengit.tms.controller.exception.NotFoundException;
import com.kaishengit.tms.dto.ResultHandler;
import com.kaishengit.tms.entity.manage.Permission;
import com.kaishengit.tms.entity.manage.Roles;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

/**
 * 角色管理Controller
 * @author fankay
 */
@Controller
@RequestMapping("/manage/roles")
public class RolesController {

    @Autowired
    private RolePermissionService rolePermissionService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("rolesList",rolePermissionService.findAllRolesWithPermission());
        return "manage/roles/home";
    }

   /**
    *描述:转向新增页面，并携带所有权限列表
    *@参数:[model] 携带权限List集合
    *@返回值java.lang.String
    */
    @GetMapping("/new")
    public String newRoles(Model model) {
        model.addAttribute("permissionList",rolePermissionService.findAllPermissions());
        return "manage/roles/new";
    }

    /** 
     *描述:新增角色
     *@参数:[roles, permissionId, redirectAttributes]
     *@返回值java.lang.String
     */
    @PostMapping("/new")
    public String newRoles(Roles roles, Integer[] permissionId, RedirectAttributes redirectAttributes) {
        rolePermissionService.saveRoles(roles,permissionId);
        redirectAttributes.addFlashAttribute("message","新增成功");
        return "redirect:/manage/roles";
    }

    /**
     *描述:编辑角色
     *@参数:[id, model]
     *@返回值java.lang.String
     */
    @GetMapping("/{id:\\d+}/edit")
    public String updateRoles(@PathVariable Integer id,
                              Model model) {

        Roles roles = rolePermissionService.findRolesWithPermissionById(id);
        if(roles == null) {
            throw new NotFoundException();
        }

        List<Permission> allPermissions = rolePermissionService.findAllPermissions();


        Map<Permission,Boolean> permissionBooleanMap = checkedPermissionList(roles.getPermissionList(),allPermissions);

        model.addAttribute("roles",roles);
        model.addAttribute("permissionMap",permissionBooleanMap);
        return "manage/roles/edit";
    }

    private Map<Permission, Boolean> checkedPermissionList(List<Permission> rolesPermissionList, List<Permission> allPermissions) {
        Map<Permission,Boolean> resultMap = Maps.newLinkedHashMap();

        for(Permission permission : allPermissions) {
            boolean flag = false;
            for(Permission rolesPermission : rolesPermissionList) {
                if(permission.getId().equals(rolesPermission.getId())) {
                    flag = true;
                    break;
                }
            }
            resultMap.put(permission,flag);
        }
        return resultMap;
    }

    /**
     *描述:保存编辑过的角色
     *@参数:[roles, permissionId, redirectAttributes]
     *@返回值java.lang.String
     */
    @PostMapping("/{id:\\d+}/edit")
    public String editRoles(Roles roles,Integer[] permissionId,
                            RedirectAttributes redirectAttributes) {
        rolePermissionService.updateRoles(roles,permissionId);

        redirectAttributes.addFlashAttribute("message","角色修改成功");
        return "redirect:/manage/roles";
    }

    /** 
     *描述:删除角色
     *@参数:[id]
     *@返回值ResponseBean
     */
    @GetMapping("/{id:\\d+}/del")
    public @ResponseBody
    ResultHandler deleteRoles(@PathVariable Integer id) {
        try {
            rolePermissionService.delRolesById(id);
            return ResultHandler.success();
        } catch (ServiceException e) {
            return ResultHandler.error(e.getMessage());
        }
    }

}
