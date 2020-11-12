package com.zxin.java.spring.redisson;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author zxin
 */
@Data
@AllArgsConstructor
public class DKey {
    private String name;
    private LocalDate start;
    private Integer age;
}
