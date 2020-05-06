package com.zxin.java.spring.huazhu.reception.bean;

import com.sun.org.apache.xerces.internal.util.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * @author zxin
 */
@Data
@ApiModel
public class RequestDTO {

    @ApiModelProperty(value = "属性1", position = 2, required = true)
    private String property1;

    @ApiModelProperty(value = "属性2", example = "111", position = 1)
    private String property2;

    @ApiModelProperty(value = "星期几")
    private DayOfWeek dayOfWeek;

    @ApiModelProperty(value = "日期时间")
    private LocalDateTime localDateTime;

    @ApiModelProperty(value = "胡诌")
    private Status status;

}
