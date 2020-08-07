package com.suruomo.unified.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @author suruomo
 * @date 2020/8/7 15:36
 * @description: 自定义统一响应体
 * VO（ View Object）：显示层对象，通常是Web向模板渲染引擎层传输的对象。
 */
@Getter
@Setter
public class ResultVO<T> {
    /**
     * 状态码，比如1000代表响应成功
     */
    private int code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;
    /**
     * 响应的具体数据
     */
    private T data;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

//    public ResultVO(int code, String msg, T data) {
//        this.code = code;
//        this.msg = msg;
//        this.data = data;
//    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
