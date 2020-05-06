package com.zxin.java.spring.redisclosed;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * @author zxin
 */
@Configuration
public class RedisConfig {

    @Autowired
    private RedisConfigResource redisConfigResource;

    @Bean("disRedisTemplate")
    public RedisTemplate disRedisTemplate() {
        RedisTemplate<String, Object> template = createRedisTemplate(redisConfigResource.getHost(), redisConfigResource.getPort());
        return template;
    }

    private RedisTemplate<String, Object> createRedisTemplate(String masterHost, int masterPort, Integer... dbIndex) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new StringRedisSerializer());
        template.setConnectionFactory(getRedisConnectionFactory(masterHost, masterPort, dbIndex));
        template.setEnableTransactionSupport(true);
        template.afterPropertiesSet();
        return template;
    }

    RedisConnectionFactory getRedisConnectionFactory(String hostName, Integer port, Integer... dbIndex) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(hostName);
        redisStandaloneConfiguration.setPort(port);
        if (null != dbIndex && 0 != dbIndex.length) {
            redisStandaloneConfiguration.setDatabase(dbIndex[0]);
        }
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        //#最大空闲数
        poolConfig.setMaxIdle(redisConfigResource.getMaxIdle());
        poolConfig.setMinIdle(redisConfigResource.getMinIdle());
        //#控制一个pool可分配多少个实例
        poolConfig.setMaxTotal(redisConfigResource.getMaxTotal());
        //#最大建立连接等待时间。如果超过此时间将接到异常。设为-1表示无限制。
        poolConfig.setMaxWaitMillis(redisConfigResource.getMaxWaitMillis());
        //#连接的最小空闲时间 默认1800000毫秒(30分钟)
        poolConfig.setMinEvictableIdleTimeMillis(redisConfigResource.getMinEvictableIdleTimeMillis());
        //#每次释放连接的最大数目,默认3
        poolConfig.setNumTestsPerEvictionRun(redisConfigResource.getNumTestsPerEvictionRun());
        //#逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
        poolConfig.setTimeBetweenEvictionRunsMillis(redisConfigResource.getTimeBetweenEvictionRunsMillis());
        //#是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
        poolConfig.setTestOnBorrow(redisConfigResource.getTestOnBorrow());
        //#在空闲时检查有效性, 默认false
        poolConfig.setTestWhileIdle(redisConfigResource.getTestWhileIdle());
        LettuceClientConfiguration configuration = LettucePoolingClientConfiguration.builder()
                .commandTimeout(Duration.ofSeconds(10))
                .poolConfig(poolConfig)
                .build();
        LettuceConnectionFactory factory = new LettuceConnectionFactory(redisStandaloneConfiguration, configuration);
        factory.setShareNativeConnection(true);
        factory.setValidateConnection(true);
        factory.afterPropertiesSet();
        return factory;
    }
}
