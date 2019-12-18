package com.zxin.java.spring.redisson.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapServiceTest {

    @Autowired
    private MapService mapService;

    @Test
    public void baseTest() {
        mapService.base();
    }
}
