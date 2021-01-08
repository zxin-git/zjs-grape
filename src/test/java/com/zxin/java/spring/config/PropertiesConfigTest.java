package com.zxin.java.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class PropertiesConfigTest {

    @Autowired
    private ChanceProperties chanceProperties;

    @Test
    public void beanChanceProperties() {
        log.info(chanceProperties.toString());
    }
}