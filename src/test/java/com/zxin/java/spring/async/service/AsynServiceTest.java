package com.zxin.java.spring.async.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AsynServiceTest{
	
	private static final Logger logger = LoggerFactory.getLogger(AsynServiceTest.class);

	/**
	 * 必须不同对象间调用，异步才能生效，切记！！！
	 */
	@Autowired
	private AsynService asynService;
	
	@Autowired
	private ThreadPoolTaskExecutor asyncThreadPoolTaskExectutor;
	
	@Test
	public void testAsynExec() {
		List<String> list = Arrays.asList("1","2","3");
		asynService.asynExec(list.stream());
		logger.info("testAsynExec当前执行线程为：[{}]", Thread.currentThread().getName());
		logger.info(asyncThreadPoolTaskExectutor.getPoolSize()+"");
	}
	
	@Test
	public void testAsynFuture(){
		List<String> list = Arrays.asList("1","2","3");
		Future<String> future = asynService.asynFuture(list.stream());
		try {
			logger.info("asynResult = [{}]", future.get());
		} catch (InterruptedException | ExecutionException e) {
			logger.warn("", e);
		}
	}

}
