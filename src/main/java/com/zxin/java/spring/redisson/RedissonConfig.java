package com.zxin.java.spring.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@EnableCaching
@Configuration
public class RedissonConfig {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.timeout}")
    private Integer timeout;
    @Value("${spring.redis.database}")
    private Integer database;
    @Value("${spring.redis.pool.max-active}")
    private Integer poolSize;

    @Autowired
    @Qualifier
    @Value("${spring.redis.pool.min-idle}")
    private Integer idleSize;



    @Bean
    @Transactional
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.setThreads(Runtime.getRuntime().availableProcessors() * 2)
                .useSingleServer()
                .setAddress("redis://" + host + ":" + port)
                .setDatabase(database)
                .setPassword(password)
                .setConnectionMinimumIdleSize(idleSize)
                .setConnectionPoolSize(poolSize);

        return Redisson.create(config);
    }


}