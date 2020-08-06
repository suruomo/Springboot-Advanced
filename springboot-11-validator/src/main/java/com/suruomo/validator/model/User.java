package com.suruomo.validator.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

/**
 * @author suruomo
 * @date 2020/8/6 12:46
 * @description:
 */
@Setter
@Getter
@NoArgsConstructor
public class User {
    // @Size 注解表示一个字符串的长度或者一个集合的大小，必须在某一个范围中
    @Size(min = 5, max = 10, message = "用户名长度介于5-10个字符之间")
    private String name;

    // @NotEmpty 注解表示该字段不能为空
    @NotEmpty(message = "用户地址不为空")
    private String address;

    // @DecimalMin 注解表示对应属性值的下限
    @DecimalMin(value = "1", message = "年龄输入最小为1岁")
    // @DecimalMax 注解表示对应属性值的上限
    @DecimalMax(value = "200", message = "年龄输入最大为200")
    private Integer age;

    // @Email 注解表示对应属性格式是一个 Email
    @Email(message = "邮箱格式输入不正确")
    // @NotNull 注解表示该字段不能为null
    @NotNull(message = "邮箱不能为空")
    private String email;
}
