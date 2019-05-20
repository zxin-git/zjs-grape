/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zxin.java.spring.nacos.listener;

import static com.alibaba.nacos.api.common.Constants.DEFAULT_GROUP;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zxin.java.spring.nacos.bean.Pojo;
import com.zxin.java.spring.nacos.config.NacosConfiguration;
import com.zxin.java.spring.nacos.converter.PojoNacosConfigConverter;

/**
 * Timeout {@link NacosConfigListener}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see NacosConfiguration
 * @since 0.1.0
 */
@Configuration
public class PojoNacosConfigListener {

    public static final String POJO_DATA_ID = "pojo-data-id";

    private static final Logger logger = LoggerFactory.getLogger(PojoNacosConfigListener.class);

    @NacosInjected
    private ConfigService configService;

    /**
     * 仅在符合该转换器时才会调用
     * 
     * @param value
     * @throws InterruptedException
     */
    @NacosConfigListener(dataId = POJO_DATA_ID, converter = PojoNacosConfigConverter.class)
    public void onPojo(Pojo value) throws InterruptedException {
        logger.info("onPojo(Pojo) : {}", value);
    }
    
    @NacosConfigListener(dataId = POJO_DATA_ID)
    public void onString(String value) throws InterruptedException {
        logger.info("onString(Pojo) : {}", value);
    }
    
//  @PostConstruct
//  public void init() throws Exception {
//      // Initialize
//    	Pojo pojo = new Pojo();
//      pojo.setId(1L);
//      pojo.setName("mercyblitz");
//      pojo.setCreated(new Date());
//      // Serialization
//      ObjectMapper objectMapper = new ObjectMapper();
//      String content = objectMapper.writeValueAsString(pojo);
//      // Publish
//      configService.publishConfig(POJO_DATA_ID, DEFAULT_GROUP, content);
//  }
    
}
