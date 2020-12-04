package com.cyp.springsecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/sys_log")
    public String sys_log(){
        return "dsafasdf";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello jwt";
    }

}