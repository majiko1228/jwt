package com.cyp.springsecurity.vo;


import lombok.Data;

@Data
public class VoUser {
    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户验证码
     */
    private String code;

}
