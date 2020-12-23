package com.zxin.java.spring.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 */
@Getter
@AllArgsConstructor
public enum BusExceptionEnum {

    INNER_CALL_EXCEPTION(1000, "内部调用异常"),
    ;
    private int code;
    private String message;

    public BusinessException busException(){
        return new BusinessException(code, message);
    }

    public BusinessException busException(String message){
        return new BusinessException(code, message);
    }

}
