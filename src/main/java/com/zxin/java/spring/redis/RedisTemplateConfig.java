package com.zxin.java.spring.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 通用redis模板配置
 * 
 * @author zxin
 *
 */
@Configuration
public class RedisTemplateConfig {

	private static final Logger logger = LoggerFactory.getLogger(RedisTemplateConfig.class);
	
	@Autowired
    private RedisConnectionFactory redisConnectionFactory;
	
	/**
	 * 通用的RedisTemplate
	 * 并且实体类必须有无参构造器
	 * @return
	 */
	@Bean
	public <K, V> RedisTemplate<K, V> redisTemplate(){
		RedisTemplate<K, V> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);

		RedisSerializer<Object> jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
		RedisSerializer<String> stringRedisSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
		
        redisTemplate.afterPropertiesSet();
		return redisTemplate;
	};
	
	
}
