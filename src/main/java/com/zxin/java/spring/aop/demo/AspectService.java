package com.zxin.java.spring.aop.demo;

import com.zxin.java.spring.aop.annotation.HLog;
import com.zxin.java.spring.aop.annotation.StopWatch;
import org.springframework.stereotype.Service;

/**
 * @author zxin
 */
@Service
public class AspectService {

    @StopWatch
    public String name(String name){
        return name;
    }

    @HLog
    public String hlog(String name, String sex){
        return name + sex;
    }

}
