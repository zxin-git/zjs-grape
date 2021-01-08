package com.zxin.java.spring.config;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zxin
 */
@Configuration
@EnableConfigurationProperties
public class PropertiesConfig {

//    @ConfigurationProperties(prefix = "another")
//    @Bean
//    public RedisProperties anotherComponent() {
//        return null;
//    }


    // 使用配置文件，属性的值初始化这里bean定义所产生的bean实例的同名属性，
    @Bean
    @ConfigurationProperties(prefix = "bean.chance")
    public ChanceProperties beanChanceProperties() {
        return new ChanceProperties();
    }
}
