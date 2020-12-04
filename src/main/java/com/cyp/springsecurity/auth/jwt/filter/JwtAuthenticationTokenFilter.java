package com.cyp.springsecurity.auth.jwt.filter;


import com.cyp.springsecurity.auth.MyUserDetailsService;
import com.cyp.springsecurity.auth.jwt.utils.JwtTokenUtil;
import io.netty.util.internal.StringUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    JwtTokenUtil jwtTokenUtil;

    @Resource
    MyUserDetailsService myUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        //从网络请求头中获取token
        String jwtToken =  request.getHeader(jwtTokenUtil.getHeader());
        if(!StringUtils.isEmpty(jwtToken)){
            //从token中获取用户名
            String username = jwtTokenUtil.getUserNameFromToken(jwtToken);
            System.out.println("username:"+username);
            if (username!=null&&//用户没有被security认证过
                    SecurityContextHolder.getContext().getAuthentication()==null){
                //加载用户信息
                System.out.println("加载用户信息");
                UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
                if(jwtTokenUtil.validateToken(jwtToken, userDetails)){
                    //token合法，没有过期，给该用户进行授权
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                }
            }
        }

        filterChain.doFilter(request,response);
    }
}
