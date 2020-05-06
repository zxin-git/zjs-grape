package com.zxin.java.spring.servlet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxin
 */
@RestController
@RequestMapping("/api/resource/")
public class ResourceController {

    @GetMapping("/get")
    public String get(String name){
        return name;
    }
}
