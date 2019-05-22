package com.zxin.java.spring.cache.service;

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 
 * @author zxin
 *
 */
@CacheConfig(cacheNames = {"namespace"})	//指定了你的缓存存放在哪块命名空间
@Service
public class CacheService {

	private static final Logger logger = LoggerFactory.getLogger(CacheService.class);

	/**
	 * key参数需能序列化，
	 * 并发时缓存会有生效延迟
	 * 
	 * @param funcode
	 * @param merid
	 * @return
	 */
//	@Cacheable( key = "methodName + ':' +#p0 + '_' +#p1") 
	@Cacheable( keyGenerator="customKeyGenerator", sync = true) 
	public String license(String funcode, String merid){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			logger.warn("", e);
		}
		return ThreadLocalRandom.current().nextInt(10000)+"";
	}
}
