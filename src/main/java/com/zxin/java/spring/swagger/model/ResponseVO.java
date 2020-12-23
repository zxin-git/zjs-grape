package com.zxin.java.spring.swagger.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author zxin
 */
@Data
public class ResponseVO {

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty(value = "姓名", example = "xin")
    private String name;

    private boolean sex;

    @ApiModelProperty(value = "生日", example = "2020-11-16 15:17:00")
    private Date birthday;

    private BigDecimal salary;

    private LocalDate hireDate;

    private LocalDateTime dateTime;
}
