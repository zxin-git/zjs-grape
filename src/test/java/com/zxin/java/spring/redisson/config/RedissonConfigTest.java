package com.zxin.java.spring.redisson.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedissonConfigTest {

    @Autowired
    private RedissonClient redisson;

    @Test
    public void config() {
        RLock lock = redisson.getLock("a");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable runnable = () ->{
            try {
                lock.lock();
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        };
        executorService.execute(runnable);
        executorService.execute(runnable);
        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}