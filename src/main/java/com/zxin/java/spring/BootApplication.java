package com.zxin.java.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zxin
 *
 */
@SpringBootApplication
//@ComponentScan("com.zxin.java.spring.swagger,com.zxin.java.spring.huazhu")
@ComponentScan("com.zxin.java.spring.cloud.feign")
//@ComponentScan("com.zxin.java.spring.mybatis")
public class BootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
	
}
