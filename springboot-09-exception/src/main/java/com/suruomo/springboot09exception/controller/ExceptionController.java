package com.suruomo.springboot09exception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author suruomo
 * @date 2020/7/27 15:46
 * @description:
 */
@RestController
@RequestMapping("/api")
public class ExceptionController {

    @GetMapping("/illegalArgumentException")
    public void throwException() {
        throw new IllegalArgumentException();
    }

    @GetMapping("/nullPointerException")
    public void throwException2() {
        throw new NullPointerException();
    }
}
