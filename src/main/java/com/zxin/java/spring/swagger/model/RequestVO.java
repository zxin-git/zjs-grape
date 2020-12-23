package com.zxin.java.spring.swagger.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author zxin
 */
@Data
public class RequestVO {

    /**
     * 日期类型只加该注解即可
     */
    @ApiModelProperty(value = "生日", example = "2020-11-16 15:17:00")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthday;

    @ApiModelProperty
    private LocalDate hireDate;

    @ApiModelProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime dateTime;

}
