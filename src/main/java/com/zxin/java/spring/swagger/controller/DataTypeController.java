package com.zxin.java.spring.swagger.controller;

import com.zxin.java.spring.swagger.model.RequestVO;
import com.zxin.java.spring.swagger.model.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxin
 */
@RestController
@RequestMapping("/data")
public class DataTypeController {

    @ApiOperation("根据用户与时间获取分销奖励列表")
    @PostMapping("/post")
    public ResponseVO post(@RequestBody RequestVO requestVO){

        ResponseVO responseVO = new ResponseVO();
        return responseVO;
    }

}
