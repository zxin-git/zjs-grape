package com.zxin.java.spring.redisson.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is for redisson config
 * @author zxin
 */
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient(){
        RedissonClient redissonClient = Redisson.create(config());
        return redissonClient;
    }

    @Bean
    public Config config(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
//        config.useSingleServer().setAddress("redis://192.168.47.134:6379");
        config.setCodec(StringCodec.INSTANCE);
        return config;
    }


}
