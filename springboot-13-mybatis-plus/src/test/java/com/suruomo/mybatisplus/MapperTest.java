package com.suruomo.mybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.suruomo.mybatisplus.mapper.SysUserMapper;
import com.suruomo.mybatisplus.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 通用Mapper层接口测试
 * 普通CRUD+分页
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
     * 分页查找
     */
    @Test
    void selectByPage() {
        Page<SysUser> page = new Page<>(1, 3);
        IPage<SysUser> userIPage  = sysUserMapper.selectPage(page, null);
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数" + page.getPages());
        List<SysUser> list=userIPage.getRecords();
        list.forEach(System.out::println);
    }
    /**
     * 插入
     */
    @Test
    void insert(){
        SysUser user=new SysUser();
        user.setUserId("25");
        user.setUserName("susu");
        sysUserMapper.insert(user);
    }

    /**
     * 根据id删除
     */
    @Test
    void deleteById(){
        sysUserMapper.deleteById("zxc");
    }

    /**
     * 根据map删除
     */
    @Test
     void DeleteByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id","25");
        sysUserMapper.deleteByMap(map);
    }
    /**
     * 根据id更新
     */
    @Test
    void update(){
        SysUser user=new SysUser();
        user=sysUserMapper.selectById("ry");
        user.setUserName("ry");
        sysUserMapper.updateById(user);
    }

}
