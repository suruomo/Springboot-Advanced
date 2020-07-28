package com.suruomo.log;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author suruomo
 * @date 2020/7/28 9:29
 * @description:
 */
@RestController
public class TestController {
    @Resource
    private TestComponent testComponent;

    @GetMapping("/test")
    public String  test(){
        testComponent.processStep();
        return "成功";
    }
}
