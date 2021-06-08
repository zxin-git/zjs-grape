package com.zxin.java.spring.feign.springmvc;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zxin
 */
@Slf4j
@Component
public class AppIdFeignInterceptor implements RequestInterceptor {

    private String appId = "13046";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("appId", appId);
    }

}
