package com.zxin.java.spring.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 自定义实现
 * @author zxin
 */
@Data
@AllArgsConstructor
public class Result<T> implements Serializable {

    public static final Integer SUCCESS = 0;
    public static final Integer ERROR = 1;

    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> successData(T data) {
        return new Result(SUCCESS, "success", data);
    }

    public static Result error(int code, String message){
        return new Result(code, message, null);
    }

}
