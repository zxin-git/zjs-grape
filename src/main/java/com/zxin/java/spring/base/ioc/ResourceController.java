package com.zxin.java.spring.base.ioc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zxin
 */
@RestController
@RequestMapping("/ioc/resource")
public class ResourceController {

    @Resource
    private HoldService holdService;

    @GetMapping("/get")
    public String get(){
        return "";
    }

}
