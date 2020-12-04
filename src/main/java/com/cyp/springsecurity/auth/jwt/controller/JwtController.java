package com.cyp.springsecurity.auth.jwt.controller;


import com.cyp.springsecurity.auth.exception.AjaxResponse;
import com.cyp.springsecurity.auth.exception.CustomException;
import com.cyp.springsecurity.auth.exception.CustomExceptionType;
import com.cyp.springsecurity.commom.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;


@RestController
public class JwtController {

    @Resource
    JwtAuthService jwtAuthService;

    @RequestMapping(value = "/authentication")
    public Result login(@RequestBody Map<String, String> map){
            String username = map.get("username");
            String password = map.get("password");

            if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
                return Result.error(new CustomException(CustomExceptionType.SYSTEM_ERROR,
                        "用户名或密码不能为空"));
            }
            try {
                return Result.success(jwtAuthService.login(username,password));
            }catch (CustomException e){
                System.out.println(e);
                return Result.error(e);
            }
    }

    @RequestMapping(value = "/refreshtoken")
    public Result refresh(@RequestHeader("${jwt.header}") String token){
        return  Result.success(jwtAuthService.refreshToken(token));
    }
}
