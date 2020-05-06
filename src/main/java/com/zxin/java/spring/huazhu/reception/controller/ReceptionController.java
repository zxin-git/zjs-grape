package com.zxin.java.spring.huazhu.reception.controller;

import com.zxin.java.spring.huazhu.reception.dto.ReceptionIndexRequestDTO;
import com.zxin.java.spring.huazhu.reception.dto.ReceptionIndexResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxin
 */
@RestController
@RequestMapping("/api/reception")
@Api("接待单")
public class ReceptionController {

    @GetMapping("/index")
    @ApiOperation("匹配单个接待单信息")
    public ReceptionIndexResponseDTO index(@ApiParam(name = "证件房间状态查询类", required = true)
                                               ReceptionIndexRequestDTO requestDTO){

        System.out.println(requestDTO);
        ReceptionIndexResponseDTO responseDTO = new ReceptionIndexResponseDTO();
        responseDTO.setCrsOrderNo("ssss");
        return responseDTO;
    }
}
