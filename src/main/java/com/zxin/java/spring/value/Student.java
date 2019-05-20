package com.zxin.java.spring.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author zxin
 *
 */
@Component(value = "st")
public class Student {
    @Value("悟空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}