package com.suruomo.mybatisplus;

import com.suruomo.mybatisplus.model.SysUser;
import com.suruomo.mybatisplus.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: suruomo
 * @Date: 2020/8/25 19:38
 * @Description: Service层接口测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private SysUserService userService;

    /**
     * 插入（批量）
     *
     */
    @Test
    public void saveBatch() {
        Collection<SysUser> entityList=new ArrayList<SysUser>();
        SysUser user=new SysUser();
        user.setUserId("11");
        entityList.add(user);
        SysUser user1=new SysUser();
        user1.setUserId("33");
        entityList.add(user1);
        userService.saveBatch(entityList);
    }
    /**
     * 批量更新(根据id)
     */
    @Test
    public void updateBatch(){
        Collection<SysUser> entityList=new ArrayList<SysUser>();
        SysUser user1=userService.getById("11");
        user1.setUserName("11");
        SysUser user2=userService.getById("33");
        user2.setUserName("33");
        entityList.add(user1);
        entityList.add(user2);
        userService.updateBatchById(entityList);
    }

    /**
     * 批量删除（根据id)
     */
    @Test
    public void delete(){
        List<String> list=new ArrayList<>();
        list.add("11");
        list.add("33");
        userService.removeByIds(list);
    }

}
