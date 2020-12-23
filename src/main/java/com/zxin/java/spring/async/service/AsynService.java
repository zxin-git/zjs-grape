package com.zxin.java.spring.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.stream.Stream;

@Component
public class AsynService {
	
	private static final Logger logger = LoggerFactory.getLogger(AsynService.class);
	
	@Async("asyncThreadPoolTaskExectutor")
	public <T> void asynExec(Stream<T> stream){
		logger.info("asynExec当前执行线程为：[{}]", Thread.currentThread().getName());
		stream.forEach(System.out::println);
	}
	
	@Async("asyncThreadPoolTaskExectutor")
	public <T> Future<T> asynFuture(Stream<T> stream){
		try {
			Thread.sleep(1000 * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("asynFuture当前执行线程为：[{}]", Thread.currentThread().getName());
//		stream.forEach(System.out::println);
		return new AsyncResult<T>(stream.iterator().next());
	}
	
}
