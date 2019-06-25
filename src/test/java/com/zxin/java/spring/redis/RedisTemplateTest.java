package com.zxin.java.spring.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTemplateTest {

	private static final Logger logger = LoggerFactory.getLogger(RedisTemplateTest.class);
	
	@Autowired
	private RedisTemplate<String, Funcode> redisTemplate;
	
	@Test
	public void testBean(){
		Funcode funcode = new Funcode(1, "code", "name", 2, 3, "version");
		redisTemplate.opsForValue().set("rt:bean:2", funcode);
		Funcode fun = redisTemplate.opsForValue().get("rt:bean:2");
		System.out.println(fun.getName());
	}

}
