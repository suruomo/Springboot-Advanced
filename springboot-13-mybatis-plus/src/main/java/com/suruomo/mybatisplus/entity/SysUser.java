package com.suruomo.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @Author: suruomo
 * @Date: 2020/8/25 14:38
 * @Description:
 */
@Data
@TableName(value = "sys_user")
public class SysUser {
    /**
     * 登录账号
     * type = IdType.INPUT表示主键输入
     * 改为AUTO为自增
     */
    @TableId(type = IdType.INPUT)
    private String userId;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phonenumber;

    /**
     * 用户性别（0男 1女 2未知）
     */
    private String sex;

    /**
     * 密码
     */
    private String password;

    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 最后登陆IP
     */
    private String loginIp;

    /**
     * 最后登陆时间
     */
    private Date loginDate;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     * 时间自动填充
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     * 时间自动修改
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
