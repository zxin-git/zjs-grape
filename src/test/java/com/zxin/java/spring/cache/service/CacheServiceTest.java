package com.zxin.java.spring.cache.service;

import static org.junit.Assert.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CacheServiceTest extends CacheService {

	private static final Logger logger = LoggerFactory.getLogger(CacheServiceTest.class);

	@Autowired
	private CacheService cacheService;
	
	private ExecutorService executorService = Executors.newCachedThreadPool();
	
	@Test
	public void testLicense() {
		long start = System.currentTimeMillis();
		CountDownLatch countDownLatch = new CountDownLatch(20);
		for (int i = 0; i < 20; i++) {
			final int a = 1;
			executorService.execute(() ->{
				System.out.println(cacheService.license("funaa"+a, "meraa"+a));
				countDownLatch.countDown();
			});
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			logger.warn("", e);
		}
		System.err.println(System.currentTimeMillis() - start);
//		while(true){
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				logger.warn("", e);
//			}
//		}
	}

}
