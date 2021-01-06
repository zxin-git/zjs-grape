package com.zxin.java.spring.mybatis.plus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GradeEnum {

    PRIMARY(1, "小学"),  SECONDARY(2, "中学"),  HIGH(3, "高中");

    @EnumValue//标记数据库存的值是code
    private final int code;

    private final String description;

}