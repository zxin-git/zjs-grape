package com.zxin.java.spring.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHANGXIN130
 */
@RestController
@Slf4j
@Api("swag测试控制器")
@RequestMapping("/api")
public class SwaggerController {

    @ApiOperation("get查询操作")
    @GetMapping("/get")
    public String get(){
        return "get";
    }

    @ApiOperation("postjson操作")
    @PostMapping("/json")
    public String json(@ApiParam("参数") String req){
        return "json";
    }


}



