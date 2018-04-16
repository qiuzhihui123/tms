package com.kaishengit.tms.service;

import com.kaishengit.tms.entity.Permission;
import com.kaishengit.tms.entity.Roles;

import java.util.List;

/**
 *@Description: 处理权限相关service接口
 *@Author: 邱志辉
 *@Date 2016/4/15 0015下午 7:51
 */
public interface RolePermissionService {

    /**
     *描述: 查找所有permission
     *@返回值java.util.List<com.kaishengit.tms.entity.Permission>
     */
    List<Permission> findAllPermissions();

    /** 
     *描述:查询所有菜单类型的权限集合
     *@参数:[menuType] 菜单类型
     *@返回值java.util.List<com.kaishengit.tms.entity.Permission>
     */
    List<Permission> findPermissionByPermissionType(String menuType);

    /** 
     *描述:新增权限
     *@参数:[permission]
     *@返回值void
     */
    void savePermission(Permission permission);

    /**
     *描述:根据id查找权限对象
     *@参数:[id]权限对象的id
     *@返回值com.kaishengit.tms.entity.Permission
     */
    Permission findPermissionById(Integer id);

    /** 
     *描述:更新Permission
     *@参数:[permission]
     *@返回值void
     */
    void updatePermission(Permission permission);

    /** 
     *描述:查询所有角色以及对应权限
     *@参数:[]
     *@返回值java.util.List<com.kaishengit.tms.entity.Roles>
     */
    List<Roles> findAllRolesWithPermission();

    /** 
     *描述:新增角色并添加角色与权限关联关系
     *@参数:[roles, permissionId]
     *@返回值void
     */
    void saveRoles(Roles roles, Integer[] permissionId);

    /** 
     *描述:根据id查找角色
     *@参数:[id]
     *@返回值com.kaishengit.tms.entity.Roles
     */
    Roles findRolesWithPermissionById(Integer id);

    /** 
     *描述:更新roles对象
     *@参数:[roles, permissionId]
     *@返回值void
     */
    void updateRoles(Roles roles, Integer[] permissionId);

    /** 
     *描述:删除角色
     *@参数:[id]
     *@返回值void
     */
    void delRolesById(Integer id);
    
    /** 
     *描述:根据id删除相应权限
     *@参数:[id]
     *@返回值void
     */
    void delPermissionById(Integer id);
}
