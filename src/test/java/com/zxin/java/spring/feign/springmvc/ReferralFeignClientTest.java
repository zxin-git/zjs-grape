package com.zxin.java.spring.feign.springmvc;

import com.alibaba.fastjson.JSON;
import com.zxin.java.spring.feign.springmvc.result.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReferralFeignClientTest {

    @Autowired
    private ReferralFeignClient referralFeignClient;

    @Test
    public void list() {
        Result<String> result = referralFeignClient.list(new ReferralQuery());
        System.out.println(JSON.toJSON(result));
    }
}