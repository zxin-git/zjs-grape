package com.zxin.java.spring.aop.aspect;

import com.zxin.java.spring.aop.demo.AspectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StopWatchAspectTest {

    @Autowired
    private AspectService aspectService;

    @Test
    public void around() {
        System.out.println(aspectService.name("aaaa"));
    }

    @Test
    public void around1() {
        System.out.println(aspectService.hlog("aaaa", "bbbb"));
    }


}