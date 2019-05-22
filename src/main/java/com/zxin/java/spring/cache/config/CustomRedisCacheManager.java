package com.zxin.java.spring.cache.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;

//@Configuration
//@EnableCaching
public class CustomRedisCacheManager extends CachingConfigurerSupport {
 
//    @Bean
//    public RedisCacheConfiguration redisCacheConfiguration(){
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
//        configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer)).entryTtl(Duration.ofDays(30));
//        return configuration;
//    }
// 
//    
//    @Bean
//    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
//        //初始化一个RedisCacheWriter
//        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
//        //初始化RedisCacheManager
//        RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter, redisCacheConfiguration());
//        return cacheManager;
//    }
	
//	@Bean
//	public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
//	        //初始化一个RedisCacheWriter
//	        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
//
//	        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
//
//	        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair.fromSerializer(serializer);
//
//	        RedisCacheConfiguration defaultCacheConfig=RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);
//
//	        return new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
//	}
}
