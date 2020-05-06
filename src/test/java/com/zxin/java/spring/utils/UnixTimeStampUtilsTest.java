package com.zxin.java.spring.utils;


import org.junit.Test;

public class UnixTimeStampUtilsTest {

    @Test
    public void timestamp() {
        System.out.println(UnixTimeStampUtils.timeSecond(1583379547L));
    }

    @Test
    public void timeMill() {
        System.out.println(UnixTimeStampUtils.timeMill(1583379547567L));
    }

    @Test
    public void time() {
    }
}
