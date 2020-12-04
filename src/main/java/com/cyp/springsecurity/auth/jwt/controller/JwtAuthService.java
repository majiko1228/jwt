package com.cyp.springsecurity.auth.jwt.controller;

import com.cyp.springsecurity.auth.exception.CustomException;
import com.cyp.springsecurity.auth.exception.CustomExceptionType;
import com.cyp.springsecurity.auth.jwt.utils.JwtTokenUtil;
import com.cyp.springsecurity.pojo.MyUserDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.annotation.Resource;

@Service
public class JwtAuthService {

    @Resource
    AuthenticationManager authenticationManager;
    @Resource
    UserDetailsService userDetailsService;
    @Resource
    JwtTokenUtil jwtTokenUtil;
    /**
     * 登录认证换取JWT令牌
     * @return JWT
     */
    public String login(String username,String passwrod) throws CustomException{
       try {
           UsernamePasswordAuthenticationToken uptoken =
                   new UsernamePasswordAuthenticationToken(username,passwrod);
           Authentication authentication = authenticationManager.authenticate(uptoken);
           SecurityContextHolder.getContext().setAuthentication(authentication);
       }catch (AuthenticationException e){
           throw new CustomException(CustomExceptionType.SYSTEM_ERROR,"用户名或密码错误");
       }

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenUtil.createToken(userDetails);
    }
    public String refreshToken(String token){

        if(!jwtTokenUtil.isTokenExpired(token)){
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }
}
