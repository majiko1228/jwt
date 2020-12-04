package com.cyp.springsecurity.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Date;

@Data
@AllArgsConstructor//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@NoArgsConstructor//使用后创建一个无参构造函数
@TableName("sys_user")
public class User {

    /**
     * 用户主键id
     */

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名称
     */
    @TableField(value = "username")
    private String username;

    /**
     * 用户密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 用户邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 是否可用
     */
    @TableField(value = "enable")
    private Integer enable;

    /**
     * 注册时间
     */
    @TableField(value = "create_time")
    private Date createTime;


}
