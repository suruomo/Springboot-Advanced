package com.suruomo.springboot09exception.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author suruomo
 * @date 2020/7/27 15:40
 * @description: 全局异常处理类
 */
// 指定捕捉特定类异常 @ControllerAdvice(assignableTypes = {ExceptionController.class})
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    ErrorResponse illegalArgumentException  = new ErrorResponse(new IllegalArgumentException("请求参数错误，请稍后重试!"));
    ErrorResponse NullPointerException = new ErrorResponse(new NullPointerException("请求发生了空指针异常，请稍后再试"));

    /**
     *
     * 拦截非法参数异常
     * @param request
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ModelAndView illegalArgumentExceptionHandler(HttpServletRequest request) throws Exception {
        log.error("Requst URL : {}，Exception : {}", request.getRequestURL(),illegalArgumentException.getMessage());
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",illegalArgumentException.getMessage());
        mv.addObject("type", illegalArgumentException.getErrorTypeName());
        mv.setViewName("error");
        return mv;
    }

    /**
     * 拦截空指针异常
     * @param request
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView nullPointerExceptionHandler(HttpServletRequest request) {
        log.error("Requst URL : {}，Exception : {}", request.getRequestURL(),NullPointerException.getMessage());
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",NullPointerException.getMessage());
        mv.addObject("type", NullPointerException.getErrorTypeName());
        mv.setViewName("error");
        return mv;
    }
}
