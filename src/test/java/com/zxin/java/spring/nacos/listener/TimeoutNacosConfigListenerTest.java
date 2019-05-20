package com.zxin.java.spring.nacos.listener;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TimeoutNacosConfigListenerTest {

	private static final Logger logger = LoggerFactory.getLogger(TimeoutNacosConfigListenerTest.class);

	@Test
	public void test() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				logger.warn("", e);
			}
		}
	}

}
