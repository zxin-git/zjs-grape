package com.zxin.java.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 响应包装类
 * @author zxin
 */
@Data
@AllArgsConstructor
public class Result<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

}
