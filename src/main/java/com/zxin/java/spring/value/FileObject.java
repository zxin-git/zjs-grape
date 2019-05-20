package com.zxin.java.spring.value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 外部文件配置注入
 * @author zxin
 *
 */
@Component
//@PropertySource(value = {"classpath:config.properties","classpath:config_${another}.properties"})
@PropertySources({ @PropertySource("classpath:config.properties"), @PropertySource("classpath:config_${another}.properties")})
public class FileObject {

    @Value("${app.name}")
    private String appName; // 这里的值来自application.properties，spring boot启动时默认加载此文件

    @Value("${book.name}")
    private String bookName; // 注入第一个配置外部文件属性

    @Value("${book.name.author}")
    private String author; // 注入第二个配置外部文件属性

    @Autowired
    private Environment env;  // 注入环境变量对象，存储注入的属性值

    //省略getter和setter方法


    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("bookName=").append(bookName).append("\r\n")
                .append("author=").append(author).append("\r\n")
                .append("appName=").append(appName).append("\r\n")
                .append("env=").append(env).append("\r\n")
                // 从eniroment中获取属性值
                .append("env=").append(env.getProperty("book.name.author")).append("\r\n");
        return sb.toString();
    }

}