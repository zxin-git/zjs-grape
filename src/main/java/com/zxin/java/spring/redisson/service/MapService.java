package com.zxin.java.spring.redisson.service;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zxin
 */
@Service
@Slf4j
public class MapService {

    @Autowired
    private RedissonClient redissonClient;

    public void base(){
        RMap<String, Integer> map =  redissonClient.getMap("testMap1");
        map.put("a", 1);
        map.put("zxin", 24);
        log.info("a:[{}]", map.get("a"));
        map.entrySet().forEach(stringIntegerEntry ->
                stringIntegerEntry.setValue(stringIntegerEntry.getKey().length()));
        map.entrySet().forEach(stringIntegerEntry -> log.info("key:[{}], value:[{}]",stringIntegerEntry.getKey(), stringIntegerEntry.getValue()));
    }
}
