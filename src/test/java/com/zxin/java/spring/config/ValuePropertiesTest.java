package com.zxin.java.spring.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ValuePropertiesTest {

    @Autowired
    private ValueProperties properties;

    @Test
    public void test(){
        properties.getDateList();
    }

}