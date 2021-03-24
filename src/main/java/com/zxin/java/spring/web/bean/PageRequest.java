package com.zxin.java.spring.web.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zxin
 */
@Data
public class PageRequest {

    @NotNull
    @ApiModelProperty("分页，页码")
    private Long current = 1L;

    @NotNull
    @ApiModelProperty("分页，每页数据行")
    private Long size = 10L;

}
