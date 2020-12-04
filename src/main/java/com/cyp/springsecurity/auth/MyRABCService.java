package com.cyp.springsecurity.auth;


import com.cyp.springsecurity.mapper.UserMapper;
import com.cyp.springsecurity.pojo.MyUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

@Component("rabcService")
public class MyRABCService {

    @Resource
    private UserMapper userMapper;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    /**
     * 判断用户是否有该request资源的访问权限
     *
     */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication){
        // request.getRequestURI()   返回除去host（域名或者ip）部分的路径
        Object principal = authentication.getPrincipal();//用户主体
        //System.out.println("principal:"+principal);
        //System.out.println(((UserDetails)principal).getUsername());
        if(principal instanceof UserDetails){//instanceof 用来测试一个对象是否为一个类的实例
            String username = ((UserDetails)principal).getUsername();
            // 根据用户名称获取该用户的权限
            List<String> urls = userMapper.getUrlByName(username);
            //System.out.println("urls:"+urls);
            //判断该用户请求的路径是否属于该用户的权限
            return urls.stream().anyMatch(
                    url -> antPathMatcher.match(url,request.getRequestURI())
            );
            // 根据用户名称获取该用户的权限
//           /* Collection<? extends GrantedAuthority> authorities=((UserDetails)principal).getAuthorities();
//            List<String> urls = ((MyUserDetails)principal).getUrls();*/

//            System.out.println(urls.size());
//            System.out.println(urls.toString());
//            System.out.println(request.getRequestURI());
//
//             判断该用户请求的路径是否属于该用户的权限
//             boolean flag = urls.stream().anyMatch(url -> antPathMatcher.match(url, request.getRequestURI()));
//             return  flag;

        }
        return false;
    }
}
