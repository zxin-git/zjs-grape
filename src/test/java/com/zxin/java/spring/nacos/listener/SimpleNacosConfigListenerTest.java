package com.zxin.java.spring.nacos.listener;

import static com.alibaba.nacos.api.common.Constants.DEFAULT_GROUP;
import static org.junit.Assert.*;

import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import static com.zxin.java.spring.nacos.listener.SimpleNacosConfigListener.PROPERTIES_DATA_ID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SimpleNacosConfigListenerTest {

	private static final Logger logger = LoggerFactory.getLogger(SimpleNacosConfigListenerTest.class);

	
	@NacosInjected
    private ConfigService configService;
	
	@Test
	public void test() {
		try {
			StringBuilder builder = new StringBuilder();
			builder.append("user.id = 1");
			builder.append(SystemUtils.LINE_SEPARATOR);
			builder.append("user.name = mercyblitz");
			builder.append(SystemUtils.LINE_SEPARATOR);
			builder.append("user.github = https://github.com/mercyblitz");
			configService.publishConfig(PROPERTIES_DATA_ID, DEFAULT_GROUP, builder.toString());
		} catch (NacosException e) {
			logger.warn("", e);
		}
	}

}
