package com.zxin.java.spring.cloud.feign.client;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class CartFeignClientTest {

    @Autowired
    private CartFeignClient cartFeignClient;

    @Test
    public void getUserAndRecommendInfo() {
        String s = cartFeignClient.getUserAndRecommendInfo(1L);
        log.info(s);
    }
}