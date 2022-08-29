package com.zxin.java.spring.feign.bank;

import org.springframework.context.annotation.Bean;

/**
 * @author zxin
 */
public class CcbFeignConfiguration {

    @Bean
    public AuthRequestInterceptor authRequestInterceptor(){
        return new AuthRequestInterceptor();
    }

}
