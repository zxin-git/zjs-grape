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
public class PojoTest {

	private static final Logger logger = LoggerFactory.getLogger(PojoTest.class);

	@Autowired
	private Pojo pojo;
	
	@Test
	public void test() {
		while(true){
			logger.info("pojo: {}", pojo);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				logger.warn("", e);
			}
		}
	}

}
