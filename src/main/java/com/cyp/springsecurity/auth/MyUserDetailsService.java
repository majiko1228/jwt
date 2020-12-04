package com.cyp.springsecurity.auth;


import com.cyp.springsecurity.mapper.UserMapper;
import com.cyp.springsecurity.pojo.MyUserDetails;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //加载基础用户信息
        MyUserDetails myUserDetails =  userMapper.getUserByUserName(username);

        //加载用户角色列表
        List<String> roleCodes = userMapper.getRoleByUsername(username);

        //通过用户角色列表加载用户的资源权限列表
        List<String> authorties = userMapper.getAuthorityByRoleCodes(roleCodes);
        myUserDetails.setUrls(authorties);

        //角色是一种特殊的权限，ROLE_前缀
        roleCodes = roleCodes.stream()
                .map(rc->"ROLE_" + rc)
                .collect(Collectors.toList());
        authorties.addAll(roleCodes);

        myUserDetails.setAuthorities(
                //把逗号分隔的字符串转换为权限列表
                AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",",authorties))
        );

        return myUserDetails;
    }
}