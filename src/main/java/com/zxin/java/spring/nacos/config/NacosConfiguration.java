package com.zxin.java.spring.nacos.config;

import org.springframework.context.annotation.Configuration;

import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySources;

//@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "10.102.5.61:8848")) //监听需开启
//@NacosPropertySource(dataId = "properties-data-id", autoRefreshed = true)	//nacos配置源 -> dataId = file

@Configuration
@EnableNacosConfig
@NacosPropertySources({ 
	@NacosPropertySource(dataId = "properties-data-id", autoRefreshed = true), 
	@NacosPropertySource(dataId = "pojo-data-id", autoRefreshed = true), 
	@NacosPropertySource(dataId = "time-data-id", autoRefreshed = true)
})
public class NacosConfiguration {
	
	public static final String CURRENT_TIME_DATA_ID = "time-data-id";

}