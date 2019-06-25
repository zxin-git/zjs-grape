package com.zxin.java.spring.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Redis操作相关服务
 * 
 * @author zxin
 */
@Service
public class RedisService {

	private static final Logger logger = LoggerFactory.getLogger(RedisService.class);
	
//	@Autowired
//	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	
	@Autowired
	private HashMapper<Object, String, Object> hashMapper;
	
	public Funcode fetchFuncode(String code){
		return (Funcode) redisTemplate.opsForValue().get("func:"+code);
	}
	
	public void storeFuncodes(List<Funcode> funcodes){
		long start = System.currentTimeMillis();
		funcodes.forEach((funcode) -> {
//			stringRedisTemplate.opsForHash().putAll(funcode.getCode(), map(funcode));
			redisTemplate.opsForValue().set("func:"+funcode.getCode(), funcode);
		});
		System.out.println(System.currentTimeMillis() - start);
	}
	
	private Map<String, String> map(Funcode funcode){
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", funcode.getName());
		map.put("type", funcode.getType()+"");
		map.put("status", funcode.getStatus()+"");
		map.put("version", funcode.getVersion());
		return map;
	}
	
	public Funcode storeHash(List<Funcode> funcodes){
		Funcode funcode = funcodes.get(0);
		redisTemplate.opsForHash().putAll("hashfunc:"+funcode.getCode(), hashMapper.toHash(funcode));
		Map<Object, Object> map =redisTemplate.opsForHash().entries("hashfunc:"+funcode.getCode());
		return new ObjectMapper().convertValue(map, Funcode.class);
	}

}
