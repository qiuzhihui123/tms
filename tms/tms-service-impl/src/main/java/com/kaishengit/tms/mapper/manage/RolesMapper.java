package com.kaishengit.tms.mapper.manage;

import com.kaishengit.tms.entity.manage.Roles;
import com.kaishengit.tms.entity.manage.RolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesMapper {
    long countByExample(RolesExample example);

    int deleteByExample(RolesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Roles record);

    int insertSelective(Roles record);

    List<Roles> selectByExample(RolesExample example);

    Roles selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Roles record, @Param("example") RolesExample example);

    int updateByExample(@Param("record") Roles record, @Param("example") RolesExample example);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);

    List<Roles> findAllWithPermission();

    Roles findRolesByIdWithPermission(Integer id);

    /** 
     *@描述:根据当前登录的account的id找到他所具有的所有的角色List集合
     *@参数:[id] 当前登录account的id
     *@返回值java.util.List<com.kaishengit.tms.entity.Roles> 返回List<Roles>
     */
    List<Roles> selectRolesByAccountId(Integer id);
}