package com.suruomo.springboot10mybatis.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author suruomo
 * @date 2020/7/29 10:18
 * @description: 该接口不能被扫描到，应该和自己定义的Mapper分开。自己定义的Mapper都需要继承这个接口。
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
