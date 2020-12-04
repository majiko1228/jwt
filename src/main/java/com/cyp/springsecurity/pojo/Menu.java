package com.cyp.springsecurity.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@NoArgsConstructor//使用后创建一个无参构造函数
@TableName("sys_menu")
public class Menu {

    /**
     * 菜单id 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private int menuId;

    /**
     * 菜单名称
     */
    @TableField(value = "menu_name")
    private String menuName;

    /**
     * 父菜单id
     */
    @TableField(value = "menu_pid")
    private int menuPid;

    /**
     * 所有父菜单id
     */
    @TableField(value = "menu_pids")
    private int menuPids;

    /**
     * 是否为叶子节点
     */
    @TableField(value = "is_leaf")
    private int isLeaf;

    /**
     * url
     */
    @TableField(value = "url")
    private String url;


    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private int sort;

    /**
     * 菜单层级
     */
    @TableField(value = "level")
    private int level;

    /**
     * 菜单是否启用  0启用  1禁用
     */
    @TableField(value = "status")
    private int status;


    /**
     * 子菜单
     */
    private List<Menu> children = new ArrayList<>();
}
