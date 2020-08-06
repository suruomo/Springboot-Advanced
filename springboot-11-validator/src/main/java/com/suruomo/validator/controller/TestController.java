package com.suruomo.validator.controller;

import com.suruomo.validator.model.User;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author suruomo
 * @date 2020/8/6 12:52
 * @description:
 */
@RestController
public class TestController {

    @PostMapping("/user")
    public  String addUser(@Valid @RequestBody User user) {
        return "success";
    }
}
