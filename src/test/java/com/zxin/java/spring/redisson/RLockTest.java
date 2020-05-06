package com.zxin.java.spring.redisson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zxin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RLockTest {

    @Autowired
    private RedissonClient redisson;

    @Autowired
    private DLockDemoService dLockDemoService;

    @Test
    public void lock() {
        RLock lock = redisson.getLock("h1:r1:rp1");
        Executors.newCachedThreadPool().execute(()->{
            try{
                lock.lock();
                System.out.println("222");
                throw new RuntimeException("a");
            }finally {
                lock.unlock();
            }
        });
        Arrays.asList(1,2,3).stream().parallel().forEach(i ->{
            lockContent(lock);
        });
    }

    private void lockContent(RLock lock){
        try{
            lock.lock();
            System.out.println("111");
            throw new RuntimeException("a");
        }finally {
            lock.unlock();
        }
    }


    @Test
    public void lock1() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                dLockDemoService.demo1("2000014","King","PMS-RATE");
            });
        }
        System.out.println("q1");
        while (true){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
