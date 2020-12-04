package com.cyp.springsecurity.auth.handler;

import com.cyp.springsecurity.auth.exception.AjaxResponse;
import com.cyp.springsecurity.commom.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败处理类，返回未授权
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        int code = HttpStatus.UNAUTHORIZED;
      //  String msg = StringUtils.format("请求访问：{}，认证失败，无法访问系统资源", request.getRequestURI());

        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
       // response.getWriter().print(JSON.toJSONString();
    }
}
