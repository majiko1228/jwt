package com.cyp.springsecurity.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@NoArgsConstructor//使用后创建一个无参构造函数
@TableName("sys_org")
public class Org {

    /**
     * id主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private int menuId;

    /**
     * 组织名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 父菜单id
     */
    @TableField(value = "pid")
    private int pid;

    /**
     * 所有父菜单id
     */
    @TableField(value = "pids")
    private int pids;

    /**
     * 是否为叶子节点
     */
    @TableField(value = "is_leaf")
    private int isLeaf;

    /**
     * 手机
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private int sort;

    /**
     * 层级
     */
    @TableField(value = "level")
    private int level;

    /**
     * 是否启用  0启用  1禁用
     */
    @TableField(value = "status")
    private int status;

}
