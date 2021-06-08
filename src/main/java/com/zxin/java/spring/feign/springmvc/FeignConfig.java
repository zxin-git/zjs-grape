package com.zxin.java.spring.feign.springmvc;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients
@Configuration
public class FeignConfig {

//    public Retryer feignRetryer(){
//        //Feign 默认的配置在请求失败后，重试次数为0，即不重试。
//        //重试间隔 为100毫秒，最大重试时间为1秒，重试次数为5次
//        //return new Retryer.Default();
//        return new Retryer.Default(100,SECONDS.toMillis(1),5);
//    }
}