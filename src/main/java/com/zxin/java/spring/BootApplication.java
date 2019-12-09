package com.zxin.java.spring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author zxin
 *
 */
@SpringBootApplication
@ComponentScan("com.zxin.java.spring.jackson")
public class BootApplication {

	private static final Logger log = LoggerFactory.getLogger(BootApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
	
}
