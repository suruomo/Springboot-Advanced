package com.suruomo.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.suruomo.mybatisplus.mapper.SysUserMapper;
import com.suruomo.mybatisplus.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2020/12/23 15:07
 * @description: 查询条件构造器
 * 主要用于处理 sql 拼接，排序，实体参数查询等
 * 注意: 使用的是数据库的字段，不是java的属性名称
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryWrapperTest {
    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    public void selectByInfo(){
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        // 性别为0，姓名为a开头
        wrapper.select("user_id", "user_name", "email","sex").eq("sex", 0).like("user_name", "a");
        List<SysUser> users = sysUserMapper.selectList(wrapper);
        users.forEach(user -> System.out.println(user));
    }
}
