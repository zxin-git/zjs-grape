package com.zxin.java.spring.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author zxin
 */
public class LocalDateTimeUtils {

    public static final String FULL_DEFAULT = "yyyy-MM-dd HH:mm:ss";

    public static final ZoneOffset CST = ZoneOffset.ofHours(8);

    public static LocalDateTime parse(String text) {
        return LocalDateTime.parse(text, DateTimeFormatter.ofPattern(FULL_DEFAULT));
    }

    public static LocalDateTime parse(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneOffset.ofHours(8));
    }

    public static LocalDateTime parse(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.ofHours(8));
    }


    public static long toTimestamp(LocalDateTime time) {
        return time.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

}
