package com.suruomo.user;

import com.suruomo.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class ConsumerUserApplicationTests {

    @Resource
    UserService userService;

    @Test
    public void contextLoads() {

        userService.hello();
    }

}
