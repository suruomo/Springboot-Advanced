package com.suruomo.springboot10mybatis.service;

import com.suruomo.springboot10mybatis.mapper.UserMapper;
import com.suruomo.springboot10mybatis.model.User;
import com.suruomo.springboot10mybatis.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author suruomo
 * @date 2020/7/29 13:31
 * @description:
 */
@Repository("userService")
public class UserServiceImpl extends BaseService<User> implements UserService{

    @Autowired
    protected UserMapper mapper;


    @Override
    public User selectByUserName(String userName) {
        return mapper.selectByUserName(userName);
    }
}
