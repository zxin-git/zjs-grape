package com.zxin.java.spring.huazhu.press;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.junit.Test;

public class PressTest {

    @Test
    public void name(){
        String s = "{\"hotelId\":\"2000014\",\"count\":null}";
        Output o = JSON.parseObject(s, Output.class);
        System.out.println(o);
    }

    @Data
    private static class Output{
        private String hotelId;
        private int count;
    }

    @Test
    public void aaa(){
        Integer a = null;
        int b = a;
        System.out.println(b);
    }

}