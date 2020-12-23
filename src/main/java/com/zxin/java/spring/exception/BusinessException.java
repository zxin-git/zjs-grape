package com.zxin.java.spring.exception;

import lombok.Data;

/**
 * @author zxin
 */
@Data
public class BusinessException extends RuntimeException{

    private int code;
    private String message;

    public BusinessException(int code, String message){
        this.code = code;
        this.message = message;
    }

}
