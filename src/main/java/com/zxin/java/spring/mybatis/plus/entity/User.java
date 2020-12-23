package com.zxin.java.spring.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author zxin
 */
@Data
@AllArgsConstructor
@TableName("user")
public class User {

    private Long id;

    private String name;

    private Integer age;

    private String email;
}
