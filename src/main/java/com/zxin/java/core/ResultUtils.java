package com.zxin.java.core;

import org.springframework.http.HttpStatus;

/**
 * @author zxin
 */
public class ResultUtils {

    public static <T> Result<T> ok(T data){
        return new Result<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }

}
