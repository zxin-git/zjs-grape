package com.zxin.java.spring.test;

import org.apache.commons.lang3.time.DurationFormatUtils;

import java.time.Duration;

/**
 * @author zxin
 */
public class DurationTest {

    public static void main(String[] args) {
        Duration duration = Duration.parse("PT48H");
        String a = DurationFormatUtils.formatDuration(1000000, "dd天 HH:mm:ss");
        System.out.println(duration.toDays());
        System.out.println(a);
    }
}
