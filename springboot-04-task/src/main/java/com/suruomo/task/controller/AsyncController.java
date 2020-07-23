package com.suruomo.task.controller;

import com.suruomo.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author suruomo
 * @date 2020/7/23 9:03
 * @description:
 */
@Controller
public class AsyncController {
    @Autowired
    AsyncService asyncService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println(1);
        asyncService.hello();
        System.out.println(4);
        return "success";
    }

}
