package com.suruomo.validator.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author suruomo
 * @date 2020/8/6 13:04
 * @description: 异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 参数校验全局异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,Object> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        Map<String,Object> map=new HashMap<>();
        List<String> errors=new ArrayList<>();
        if (!e.getBindingResult().getAllErrors().isEmpty()){
            //循环获取异常信息
            for (ObjectError error:e.getBindingResult().getAllErrors()){
                errors.add(error.getDefaultMessage());
            }
        }
        map.put("code","1");
        map.put("msg",errors);
        return map;
    }
}
