package com.zxin.java.spring.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ZHANGXIN130
 */
@Data
@AllArgsConstructor
public class Person {

    private Long id;

    private String name;

    private Integer age;

    private String email;
}
