package com.zxin.java.spring.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZHANGXIN130
 */
@Configuration
@MapperScan("com.zxin.java.spring.mybatis.mapper")
public class MybatisConfig {

}
