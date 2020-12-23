package com.zxin.java.spring.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zxin
 */
@RestControllerAdvice
public class BusExceptionHandler {

    /**
     * 异常返回，靠返回码，data为空
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public Result businessException(BusinessException e) {
        return Result.error(e.getCode(), e.getMessage());
    }

}
