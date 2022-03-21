package com.zxin.java.spring.nacos.config;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.Configuration;

/**
 * @author zxin
 */
@Configuration
@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class NacosConfig {



}
