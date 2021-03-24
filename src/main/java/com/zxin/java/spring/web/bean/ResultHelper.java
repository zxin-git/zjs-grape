package com.zxin.java.spring.web.bean;

import lombok.Data;

@Data
public class ResultHelper<T> {
    public static final String SUCCESS = "0";
    public static final String ERROR = "1";

    private String code;
    private String message;
    private T data;

    public static <T> ResultHelper<T> create(String code, String message) {
        return new ResultHelper<>(code, message, null);
    }

    public static <T> ResultHelper<T> create(String code, String message, T data) {
        return new ResultHelper<>(code, message, data);
    }

    public static <T> ResultHelper<T> successData(String message, T data) {
        return create(SUCCESS, message, data);
    }

    public static <T> ResultHelper<T> successMessage(String message) {
        return successData(message, null);
    }

    public static <T> ResultHelper<T> successData(T data) {
        return successData(null, data);
    }

    public static <T> ResultHelper<T> success() {
        return successMessage(null);
    }

    public static <T> ResultHelper<T> errorData(String message, T data) {
        return create(ERROR, message, data);
    }

    public static <T> ResultHelper<T> error() {
        return errorMessage(null);
    }

    public static <T> ResultHelper<T> errorData(T data) {
        return errorData(null, data);
    }

    public static <T> ResultHelper<T> errorMessage(String message) {
        return errorData(message, null);
    }

    public static <T> ResultHelper<T> error(Error e) {
        return e == null ? null : create(ERROR, e.getMessage());
    }

    public static <T> ResultHelper<T> error(Exception e) {
        return e == null ? null : create(ERROR, e.getMessage());
    }

    public ResultHelper() {
        this.setMessage("");
    }

    ResultHelper(String code, String message, T data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }

    public boolean isSuccess() {
        return SUCCESS.equals(this.code);
    }
}
