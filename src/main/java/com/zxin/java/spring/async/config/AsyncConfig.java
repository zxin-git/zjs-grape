/**
 * 
 */
package com.zxin.java.spring.async.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 异步线程池注入配置类
 * 需加入{@link EnableAsync}}注解生效异步
 * @author zxin
 */
@EnableAsync
@Configuration
public class AsyncConfig {
	
	/**
	 * 异步线程池
	 * @return
	 */
	@Bean("asyncThreadPoolTaskExectutor")
	public ThreadPoolTaskExecutor asyncThreadPoolTaskExectutor(){
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(20);
		taskExecutor.setMaxPoolSize(200);
		taskExecutor.setQueueCapacity(25);
		taskExecutor.setThreadNamePrefix("async-");
		taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		taskExecutor.initialize();
		return taskExecutor;
	}

}
