package com.zxin.java.spring.redis;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * redis for hash
 * @author zxin
 *
 */
//@SpringBootTest
//@RunWith(SpringRunner.class)
public class HashMapperTest {

	private static final Logger logger = LoggerFactory.getLogger(HashMapperTest.class);
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private HashMapper<Object, String, Object> hashMapper = new Jackson2HashMapper(false);
	
	@Test
	public void hash(){
		Funcode funcode = new Funcode(1, "code", "name", 2, 3, "version");
//		stringRedisTemplate.opsForHash().putAll(funcode.getCode(), hashMapper.toHash(funcode));
//		Map<Object, Object> map = stringRedisTemplate.opsForHash().entries(funcode.getCode());
		Map<String, Object> map = hashMapper.toHash(funcode);
		Funcode func = (Funcode) hashMapper.fromHash(map);
		System.out.println(func);
	}
	
	@Test
	public void hashmapper(){
		Funcode funcode = new Funcode(1, "code", "name", 2, 3, "version");
		Map<String, Object> map = hashMapper.toHash(funcode);
		Funcode func = (Funcode) hashMapper.fromHash(map);
		System.out.println(func);
	}
	

}
