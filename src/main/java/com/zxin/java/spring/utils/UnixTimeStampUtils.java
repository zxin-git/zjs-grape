package com.zxin.java.spring.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author zxin
 */
public class UnixTimeStampUtils {

    public static long timestamp(String string){
        LocalDateTime localDateTime = LocalDateTime.parse(string);
        return localDateTime.toEpochSecond(ZoneOffset.ofHours(8));
    }

    public static String timeSecond(long second){
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(second, 0, ZoneOffset.ofHours(8));
        return localDateTime.toString();
    }

    public static String timeMill(long mill){
        long second = mill / 1000;
        long nano = (mill % 1000) * 1000;
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(second, 0, ZoneOffset.ofHours(8));
        return localDateTime.toString();
    }
}
