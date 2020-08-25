package com.suruomo.mybatisplus;

import com.suruomo.mybatisplus.mapper.SysUserMapper;
import com.suruomo.mybatisplus.model.SysUser;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Mapper层接口测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class MapperTest {

    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 查找所有
     */
    @Test
    void selectList() {
        List<SysUser> userList = sysUserMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    /**
     * 插入
     */
    @Test
    void insert(){
        SysUser user=new SysUser();
        user.setUserId("22");
        user.setUserName("susu");
        sysUserMapper.insert(user);
    }

    /**
     * 删除
     */
    @Test
    void delete(){
        sysUserMapper.deleteById("zxc");
    }

    /**
     * 更新
     */
    @Test
    void update(){
        SysUser user=new SysUser();
        user=sysUserMapper.selectById("ry");
        user.setUserName("ry");
        sysUserMapper.updateById(user);
    }

}
