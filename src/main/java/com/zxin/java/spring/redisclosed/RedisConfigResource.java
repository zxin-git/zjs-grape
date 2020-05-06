package com.zxin.java.spring.redisclosed;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zxin
 */
@Data
@Component
public class RedisConfigResource {

    @Value("${redis.host:10.100.244.34}")
    private String host;

    @Value("${redis.port:6379}")
    private int port;

    @Value("${redis.maxWaitMillis:5000}")
    private Integer maxWaitMillis;

    @Value("${redis.maxIdle:20}")
    private Integer maxIdle;

    @Value("${redis.minIdle:10}")
    private Integer minIdle;

    @Value("${redis.maxTotal:100}")
    private Integer maxTotal;

    @Value("${redis.minEvictableIdleTimeMillis:5000}")
    private Long minEvictableIdleTimeMillis;

    @Value("${redis.numTestsPerEvictionRun:5}")
    private Integer numTestsPerEvictionRun;

    @Value("${redis.timeBetweenEvictionRunsMillis:30000}")
    private Long timeBetweenEvictionRunsMillis;

    @Value("${redis.testOnBorrow:true}")
    private Boolean testOnBorrow;

    @Value("${redis.testWhileIdle:true}")
    private Boolean testWhileIdle;
}
