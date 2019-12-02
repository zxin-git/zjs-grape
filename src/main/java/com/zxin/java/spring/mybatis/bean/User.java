package com.zxin.java.spring.mybatis.bean;

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

    private int id;

    private String name;

    private int age;

    private String email;

}
