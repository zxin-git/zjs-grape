package com.zxin.java.spring.validate.exception;

import com.zxin.java.spring.exception.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * ConstraintViolationException
 */
@RestControllerAdvice("com.zxin.java.spring.validate")
@Slf4j
public class ExceptionControllerAdvice {

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Result<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
//        log.error(e.getMessage(), e);
//        String message = e.getBindingResult().getFieldError().getDefaultMessage();
//        return Result.error(1, message);
//    }

}