package com.zxin.java.spring.redisson.collection;

import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapExamples {

    public static void main(String[] args) throws IOException {
        // connects to 127.0.0.1:6379 by default

        RedissonClient redisson = Redisson.create(config());
        
        RMap<String, Integer> map =  redisson.getMap("myMap");
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        
        boolean contains = map.containsKey("a");
        
        Integer value = map.get("c");
//        Integer updatedValue = map.addAndGet("a", 32);
        
        Integer valueSize = map.valueSize("c");
        
        Set<String> keys = new HashSet<String>();
        keys.add("a");
        keys.add("b");
        keys.add("c");
        Map<String, Integer> mapSlice = map.getAll(keys);
        
        // use read* methods to fetch all objects
        Set<String> allKeys = map.readAllKeySet();
        Collection<Integer> allValues = map.readAllValues();
        Set<Map.Entry<String, Integer>> allEntries = map.readAllEntrySet();
        
        // use fast* methods when previous value is not required
        boolean isNewKey = map.fastPut("a", 100);
        boolean isNewKeyPut = map.fastPutIfAbsent("d", 33);
        long removedAmount = map.fastRemove("b");
        
        redisson.shutdown();
    }

    public static Config config(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.47.131:6379");
        config.setCodec(StringCodec.INSTANCE);
        return config;
    }
    
}