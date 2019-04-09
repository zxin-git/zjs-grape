package com.zxin.java.spring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zxin
 *
 */
@SpringBootApplication
public class BootApplication {

	private static final Logger log = LoggerFactory.getLogger(BootApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
	
}
