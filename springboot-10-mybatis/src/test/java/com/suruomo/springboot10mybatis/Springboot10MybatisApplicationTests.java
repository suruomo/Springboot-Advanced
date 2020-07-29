package com.suruomo.springboot10mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suruomo.springboot10mybatis.model.User;
import com.suruomo.springboot10mybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试
 */
@SpringBootTest
class Springboot10MybatisApplicationTests {

    @Resource
    private UserService userService;

    /**
     * 通用mapper的插入测试
     */
    @Test
    void save() {
        User user = new User();
        user.setUserId("susu");
        user.setUserName("suruomo");
        user.setEmail("1232@qq.com");
        user.setSex("1");
        user.setPassword("xMpCOKC5I4INzFCab3WEmw==");
        userService.save(user);
    }

    /**
     * 通用mapper的删除测试
     */
    @Test
    void delete() {
        User user = new User();
        user.setUserId("susu");
        this.userService.delete(user);
    }

    /**
     * 通用mapper的查询单个测试
     */
    @Test
    void select(){
        String userId="a";
        System.out.println(userService.selectByKey(userId).getEmail());
    }

    /**
     * 通用mapper的查询全部测试
     */
    @Test
    void selectAll(){
        List<User> list=new ArrayList<>();
        list=userService.selectAll();
        for(User user:list){
            System.out.println(user.getUserId());
        }
    }

    /**
     * 通用mapper的example自定义查询
     */
    @Test
    void selectByExample(){
        Example example = new Example(User.class);
        example.createCriteria().andCondition("user_name like '%a%'");
        List<User> userList = this.userService.selectByExample(example);
        for (User u : userList) {
            System.out.println(u.getUserName());
        }
    }

    /**
     * 通用mapper的更改
     */
    @Test
    void updateAll(){
        User user=userService.selectByKey("zxc");
        user.setLoginIp("127.0.0.1");
        userService.updateAll(user);
    }

    /**
     * 分页查询
     */
    @Test
    void selectByPage(){
        PageHelper.startPage(1 ,2);
        List<User> list = userService.selectAll();
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        List<User> result = pageInfo.getList();
        for (User u : result) {
            System.out.println(u.getUserName());
        }
    }

    /**
     * 自定义mapper查询
    */
    @Test
    void selectByUserName(){
        String userName="b";
        System.out.println(userService.selectByUserName(userName));
    }

}
