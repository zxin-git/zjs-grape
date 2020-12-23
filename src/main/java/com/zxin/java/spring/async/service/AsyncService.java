package com.zxin.java.spring.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AsyncService {

    @Async
    public <T, R> AsyncResult<R> async(Function<T, R> function, T t){
        return new AsyncResult<R>(function.apply(t));
    }
}