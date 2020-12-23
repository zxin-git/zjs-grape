package com.zxin.java.spring.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class Slf4jServiceTest {

    @Test
    public void testNull() {
        String a = null;
        log.info("testNull [{}]", a);
    }
}