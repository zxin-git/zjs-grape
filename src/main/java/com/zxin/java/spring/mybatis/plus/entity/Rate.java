package com.zxin.java.spring.mybatis.plus.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author zxin
 */
@Data
@ToString(callSuper = true)
public class Rate extends Entity{

    private String code;

    private String name;

    private Long stock;

    private Long expend;

}
