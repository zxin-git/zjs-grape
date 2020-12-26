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
}
