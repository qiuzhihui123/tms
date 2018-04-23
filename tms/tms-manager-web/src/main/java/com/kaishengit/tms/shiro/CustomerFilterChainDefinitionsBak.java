package com.kaishengit.tms.shiro;

import com.kaishengit.tms.entity.manage.Permission;
import com.kaishengit.tms.service.RolePermissionService;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CustomerFilterChainDefinitionsBak implements FactoryBean<Ini.Section> {

    private String filterChainDefinitions;
    @Autowired
    private RolePermissionService rolePermissionService;


    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    @Override
    public Ini.Section getObject() throws Exception {
       Ini ini = new Ini();
       ini.load(filterChainDefinitions);

        List<Permission> permissionList = rolePermissionService.findAllPermissions();
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);

        for (Permission permission : permissionList){
            section.put(permission.getUrl(),"perms["+permission.getPermissionCode()+"]");
        }
        section.put("/**","user");
        return section;
    }

    @Override
    public Class<?> getObjectType() {
        return Ini.Section.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
