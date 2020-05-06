package com.zxin.java.spring.redisson;

/**
 * @author zxin
 */
public class DLockException extends Exception {

    public DLockException(String message) {
        super(message);
    }

    public DLockException(String message, Throwable cause) {
        super(message, cause);
    }
}
