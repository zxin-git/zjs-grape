package com.zxin.java.spring.cloud.feign.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "CART", url = "http://10.111.254.159:8080")
public interface CartFeignClient {

    @GetMapping("/v1/yk/getUserAndRecommendInfo")
    String getUserAndRecommendInfo(@RequestParam("userId") Long userId);

}