package com.suruomo.springboot09exception.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author suruomo
 * @date 2020/7/27 15:34
 * @description: 包装异常信息
 */
@Data
@Getter
@Setter
public class ErrorResponse {
    private String message;
    private String errorTypeName;

    public ErrorResponse(Exception e) {
        this(e.getClass().getName(), e.getMessage());
    }

    public ErrorResponse(String errorTypeName, String message) {
        this.errorTypeName = errorTypeName;
        this.message = message;
    }
}
