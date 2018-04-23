package com.kaishengit.tms.service.impl;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.kaishengit.tms.entity.manage.*;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.mapper.manage.AccountRolesMapper;
import com.kaishengit.tms.mapper.manage.PermissionMapper;
import com.kaishengit.tms.mapper.manage.RolesMapper;
import com.kaishengit.tms.mapper.manage.RolesPermissionMapper;
import com.kaishengit.tms.service.RolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *@Description: 处理权限相关service接口实现类
 *@Author: 邱志辉
 *@Date 2016/4/15 0015下午 7:51
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    public static final Logger logger = LoggerFactory.getLogger(RolePermissionServiceImpl.class);

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RolesMapper rolesMapper;

    @Autowired
    private RolesPermissionMapper rolesPermissionMapper;

    @Autowired
    private AccountRolesMapper accountRolesMapper;
    /**
     * 描述: 查找所有permission
     *
     * @返回值java.util.List<com.kaishengit.tms.entity.Permission>
     */
    @Override
    public List<Permission> findAllPermissions() {
        PermissionExample permissionExample =  new PermissionExample();
        List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);
        List<Permission> appearList = new ArrayList<>();

        int primaryParentId = 0;

        treeList(permissionList,appearList, primaryParentId);
        return appearList;
    }

    @Override
    public List<Permission> findPermissionByPermissionType(String menuType) {
        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria().andPermissionTypeEqualTo(menuType);
        return permissionMapper.selectByExample(permissionExample);
    }

    /**
     * 描述:新增权限
     *
     * @param permission
     * @参数:[permission] 权限对象
     * @返回值void
     */
    @Override
    public void savePermission(Permission permission) {
       permissionMapper.insertSelective(permission);
       logger.info("新增权限,{}",permission);

    }

    /**
     * 描述:根据id查找权限对象
     *
     * @param id
     * @参数:[id]权限对象的id
     * @返回值com.kaishengit.tms.entity.Permission
     */
    @Override
    public Permission findPermissionById(Integer id) {
        Permission permission = permissionMapper.selectByPrimaryKey(id);
        System.out.println(permission);
        return permission;
    }

    /**
     * 描述:更新Permission
     *
     * @param permission
     * @参数:[permission]
     * @返回值void
     */
    @Override
    public void updatePermission(Permission permission) {

        permission.setUpdateTime(new Date());
        permissionMapper.updateByPrimaryKeySelective(permission);

        logger.info("更新权限{}",permission);
    }

    /**
     * 描述:查询所有角色以及对应权限
     *
     * @参数:[]
     * @返回值java.util.List<com.kaishengit.tms.entity.Roles>
     */
    @Override
    public List<Roles> findAllRolesWithPermission() {
        return rolesMapper.findAllWithPermission();
    }

    /**
     * 描述:新增角色并添加角色与权限关联关系
     *
     * @param roles
     * @param permissionId
     * @参数:[roles, permissionId]
     * @返回值void
     */
    @Override
        public void saveRoles(Roles roles, Integer[] permissionId) {
        roles.setUpdateTime(new Date());
        rolesMapper.insertSelective(roles);

        for(Integer perId : permissionId){
            RolesPermissionKey rolesPermissionKey = new RolesPermissionKey();
            rolesPermissionKey.setPermissionId(perId);
            rolesPermissionKey.setRolesId(roles.getId());

            rolesPermissionMapper.insert(rolesPermissionKey);
        }
        logger.info("保存角色{}",roles);

    }

    /**
     * 描述:根据角色id查找角色并带有该角色相应的权限
     * @参数:[id]
     * @返回值com.kaishengit.tms.entity.Roles
     */
    @Override
    public Roles findRolesWithPermissionById(Integer id) {
        return rolesMapper.findRolesByIdWithPermission(id);
    }

    /**
     * 描述:更新roles对象
     * 先删除角色权限对应关系，再建立新的关联关系
     * 然后保存更新后的roles对象
     *
     * @param roles
     * @param permissionId
     * @参数:[roles, permissionId]
     * @返回值void
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateRoles(Roles roles, Integer[] permissionId) {

        RolesPermissionExample rolesPermissionExample = new RolesPermissionExample();
        rolesPermissionExample.createCriteria().andRolesIdEqualTo(roles.getId());

        rolesPermissionMapper.deleteByExample(rolesPermissionExample);

        for(Integer perId : permissionId){
            RolesPermissionKey rolesPermissionKey = new RolesPermissionKey();
            rolesPermissionKey.setRolesId(roles.getId());
            rolesPermissionKey.setPermissionId(perId);
            rolesPermissionMapper.insert(rolesPermissionKey);
        }

        rolesMapper.updateByPrimaryKeySelective(roles);

        logger.info("更新角色{}",roles);

    }

    /**
     * 描述:根据id删除角色
     *
     * @param id
     * @参数:[id]
     * @返回值void
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delRolesById(Integer id) {

        AccountRolesExample accountRolesExample = new AccountRolesExample();
        accountRolesExample.createCriteria().andRolesIdEqualTo(id);

        List<AccountRolesKey> accountRolesKeys = accountRolesMapper.selectByExample(accountRolesExample);
        if(accountRolesKeys != null && !accountRolesKeys.isEmpty()) {
            throw new ServiceException("该角色正在被使用，删除失败");
        }

        RolesPermissionExample rolesPermissionExample = new RolesPermissionExample();
        rolesPermissionExample.createCriteria().andRolesIdEqualTo(id);

        rolesPermissionMapper.deleteByExample(rolesPermissionExample);

        Roles roles = rolesMapper.selectByPrimaryKey(id);
        rolesMapper.deleteByPrimaryKey(id);

        logger.info("删除角色 {}",roles);

    }

    /**
     * 描述:根据id删除相应权限
     *
     * @param id
     * @参数:[id]
     * @返回值void
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delPermissionById(Integer id) {
        //先查询有没有子节点引用该权限
        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria().andParentIdEqualTo(id);

        List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);
        if(permissionList != null && !permissionList.isEmpty()){
            throw new ServiceException("该权限被其他权限引用，不能删除");
        }

        //再查询有没有角色引用
        RolesPermissionExample rolesPermissionExample = new RolesPermissionExample();
        rolesPermissionExample.createCriteria().andPermissionIdEqualTo(id);

        List<RolesPermissionKey> rolesPermissionKeyList = rolesPermissionMapper.selectByExample(rolesPermissionExample);
        if(rolesPermissionKeyList != null && !rolesPermissionKeyList.isEmpty()){
            throw new ServiceException("该权限被角色引用,不能删除");
       }

       //经过以上筛选，可以删除
        Permission permission = permissionMapper.selectByPrimaryKey(id);
        permissionMapper.deleteByPrimaryKey(id);
        logger.info("删除权限,{}",permission);




    }

    /**
     * @param id
     * @描述:根据account的id去查找该账户所具有的角色
     * @参数:[id] 当前account的id
     * @返回值java.util.List<com.kaishengit.tms.entity.Roles> roles的List集合
     */
    @Override
    public List<Roles> findAccountRolesByAccountId(Integer id) {
        return rolesMapper.selectRolesByAccountId(id);
    }

    /**
     *@描述: 根据数据库查出来的permission列表重新排序用于正确显示列表
     *@参数: [permissionList（查出来的所有permission）,
     *        appearList(重新排序后的permission列表),
     *        parentId（最高级的父id）]
     *@返回值 void
     */
   /* private void treeList(List<Permission> sourceList, List<Permission> appearList, int parentId) {
        List<Permission> tempList = Lists.newArrayList(Collections2.filter(sourceList, permission -> permission.getParentId().equals(parentId)));

        for(Permission permission : tempList) {
            appearList.add(permission);
            treeList(sourceList,appearList,permission.getId());
        }
    }*/
    private void treeList(List<Permission> permissionList, List<Permission> appearList,int parentId) {
        List<Permission> tempList = Lists.newArrayList(Collections2.filter(permissionList, new Predicate<Permission>() {

            @Override
            public boolean apply(Permission input) {
                return parentId == input.getParentId();
            }
        }));


        for(Permission permission : tempList){

                appearList.add(permission);
                treeList(permissionList,appearList,permission.getId());

        }

    }
}
