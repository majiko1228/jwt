package com.cyp.springsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyp.springsecurity.pojo.MyUserDetails;
import com.cyp.springsecurity.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    //根据id查询用户
    MyUserDetails getUserByUserName(String username);

    //根据用户名查询用户角色
    List<String> getRoleByUsername(String username);

    //根据用户角色查询用户权限
    List<String> getAuthorityByRoleCodes(@Param("roleCodes") List<String> roleCodes);

    //根据用户名查询用户权限（唯一标识url）
    List<String> getUrlsByUserName(String username);

    //根据用户名查询用户权限（唯一标识url）
    List<String> getUrlByName(String username);
}
