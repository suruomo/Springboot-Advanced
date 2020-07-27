package com.suruomo.springboot09exception.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author suruomo
 * @date 2020/7/27 15:40
 * @description: 全局异常处理类
 */
// 指定捕捉特定类异常 @ControllerAdvice(assignableTypes = {ExceptionController.class})
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    ErrorResponse illegalArgumentResponse = new ErrorResponse(new IllegalArgumentException("参数错误!"));
    ErrorResponse NullPointerException = new ErrorResponse(new NullPointerException("错误：空对象！"));

    /**
     * 拦截非法参数异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> illegalArgumentExceptionHandler(Exception e) {
            return ResponseEntity.status(400).body(illegalArgumentResponse);
    }

    /**
     * 拦截空指针异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ErrorResponse> nullPointerExceptionHandler(Exception e) {
        return ResponseEntity.status(500).body(NullPointerException);
    }
}
