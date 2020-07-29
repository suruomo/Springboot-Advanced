package com.suruomo.springboot10mybatis.mapper;

import com.suruomo.springboot10mybatis.config.MyMapper;
import com.suruomo.springboot10mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends MyMapper<User> {
    User selectByUserName(String userName);
}