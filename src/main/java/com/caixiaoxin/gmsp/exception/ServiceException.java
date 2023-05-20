package com.caixiaoxin.gmsp.exception;

import lombok.Getter;

/**
 * 自定义异常
 */
@Getter
public class ServiceException extends RuntimeException{
    private String Code;

    public ServiceException(String code, String msg) {
        super(msg);
        this.Code = code;
    }
}
