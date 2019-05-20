package com.zxin.java.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("com.zxin.java.spring.config") // search the com.company package for @Component classes
@Import({ CustomerConfig.class, SchedulerConfig.class })
//@ImportResource("classpath:dao.xml")
public class AppConfig {
  
}