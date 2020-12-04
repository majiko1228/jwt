package com.cyp.springsecurity.controller;


import com.cyp.springsecurity.commom.Result;
import com.cyp.springsecurity.vo.VoUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/authentication")

    public Result odLogin(@RequestParam VoUser user){
            return null;
    }
}
