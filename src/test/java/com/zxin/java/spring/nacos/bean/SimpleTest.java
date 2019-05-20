package com.zxin.java.spring.nacos.bean;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SimpleTest {

	private static final Logger logger = LoggerFactory.getLogger(SimpleTest.class);

	@Autowired
	private Simple simple;
	
	@Test
	public void test(){
		while(true){
			logger.info("simple: {}", simple);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				logger.warn("", e);
			}
		}
	}
	
}
