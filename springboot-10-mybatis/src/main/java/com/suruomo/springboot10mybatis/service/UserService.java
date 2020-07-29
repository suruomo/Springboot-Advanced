package com.suruomo.springboot10mybatis.service;

import com.suruomo.springboot10mybatis.model.User;
import com.suruomo.springboot10mybatis.service.common.IService;

/**
 * @author suruomo
 * @date 2020/7/29 13:30
 * @description:
 */
public interface UserService extends IService<User> {
    /**
     * 自定义根据用户名称查询
     * @param userName
     * @return
     */
    User selectByUserName(String userName);
}
