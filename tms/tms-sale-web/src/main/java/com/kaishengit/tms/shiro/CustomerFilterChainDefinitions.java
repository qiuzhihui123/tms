package com.kaishengit.tms.shiro;

import com.kaishengit.tms.entity.manage.Permission;
import com.kaishengit.tms.service.RolePermissionService;
import org.apache.shiro.config.Ini;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;


public class CustomerFilterChainDefinitions {

 /*   @Autowired
    private RolePermissionService rolePermissionService;*/
    private String filterChainDefinitions;
    private Logger logger = LoggerFactory.getLogger(CustomerFilterChainDefinitions.class);


    public void setShiroFilter(AbstractShiroFilter shiroFilter) {
        this.shiroFilter = shiroFilter;
    }

    private AbstractShiroFilter shiroFilter;

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    /**
     *@描述:初始化shiro过滤器的映射关系
     *@参数:[]
     *@返回值void
     */
    @PostConstruct //此注解表示在容器启动时候调用的init方法
    public  void init(){
        logger.info("初始化url开始");
        //清除之前的
        getDefaultFilterChainManager().getFilterChains().clear();
        //加载现有的
        load();
        logger.info("初始化url结束");
    }

    /**
     *@描述:更新过shiro过滤的映射关系
     *@参数:[]
     *@返回值void
     */
    public void update(){
        logger.info("重新加载url");
        //清除之前的
        getDefaultFilterChainManager().getFilterChains().clear();
        //加载现有的
        load();
        logger.info("加载url结束");
    }

    /** 
     *@描述:加载和权限的对应关系
     *@参数:[]
     *@返回值void
     */
    public void load(){
       Ini ini = new Ini();
       ini.load(filterChainDefinitions);
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);

        section.put("/**","user");

        //url和权限关系设置到shiroFilter中去
        DefaultFilterChainManager defaultFilterChainManager = getDefaultFilterChainManager();
        for (Map.Entry<String,String> entry: section.entrySet()){
            defaultFilterChainManager.createChain(entry.getKey(),entry.getValue());
        }

    }

    private DefaultFilterChainManager getDefaultFilterChainManager(){
        return (DefaultFilterChainManager) ((PathMatchingFilterChainResolver)shiroFilter.getFilterChainResolver()).getFilterChainManager();
    }

}
