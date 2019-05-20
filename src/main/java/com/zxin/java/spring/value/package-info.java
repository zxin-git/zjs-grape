/**
 * 测试注入变量的规范
 * 
 * 
 * 	注入普通字符串
	注入操作系统属性
	注入表达式结果
	注入其他Bean属性：注入Student对象的属性name
	注入文件资源
	注入URL资源
 * 
 * @value 单个值
 * @ConfigurationProperties 配置文件与对象映射
 * 
 * @PropertySource 指定外部文件 （配置源）
 * @PropertySources 指定多个配置源
 * 
 * @ImportResource(locations = {"classpath:beans.xml"}) 不推荐
 * 
 * 随机数
 * ${random.value}、${random.int}、${random.long}
   ${random.int(10)}、${random.int[1024,65536]}
 */
/**
 * @author zxin
 *
 */
package com.zxin.java.spring.value;

import org.springframework.context.annotation.PropertySource;
