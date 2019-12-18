package com.zxin.java.spring.redisson.collection;

import com.zxin.java.spring.redisson.bean.RedObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RFuture;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistributedCollectionTest {

    @Autowired
    private RedissonClient redisson;

    @Autowired
    private RedisTemplate<String, String> template;

    @Test
    public void rmap() {
        RMap<String, RedObject> map = redisson.getMap("anyMap");
        RedObject prevObject = map.put("123", new RedObject());
        RedObject currentObject = map.putIfAbsent("323", new RedObject());
        RedObject obj = map.remove("123");

        map.fastPut("321", new RedObject());
        map.fastRemove("321");

//        RFuture<RedObject> putAsyncFuture = map.putAsync("321");
//        RFuture<Void> fastPutAsyncFuture = map.fastPutAsync("321");

        map.fastPutAsync("321", new RedObject());
        map.fastRemoveAsync("321");
    }
}
