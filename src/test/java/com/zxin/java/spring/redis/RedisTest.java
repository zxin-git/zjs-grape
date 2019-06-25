package com.zxin.java.spring.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

	private static final Logger logger = LoggerFactory.getLogger(RedisTest.class);

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Test
	public void test(){
		try {
			// 保存字符串
			stringRedisTemplate.opsForValue().set("aaa", "111");
			Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
		} catch (Exception e) {
			logger.warn("", e);
		}
    }
	
	@Test
	public void testRe(){
		redisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", redisTemplate.opsForValue().get("aaa"));
	}

}
