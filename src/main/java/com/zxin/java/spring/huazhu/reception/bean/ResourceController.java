package com.zxin.java.spring.huazhu.reception.bean;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxin
 */

@RestController
@RequestMapping("/api/resource/")
public class ResourceController {


    @PostMapping("/post")
    @ApiOperation("查询post")
    public ResponseDTO post(@ApiParam("aaa") RequestDTO requestDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        return responseDTO;
    }

}
