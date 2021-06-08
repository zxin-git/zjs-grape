package com.zxin.java.spring.feign.springmvc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BusPushNoticeReq<T> {

    /**
     * 事件编码
     */
    private String event;

    /**
     * 全局ID,不给不保证消息唯一性
     */
    private String traceId;

    /**
     * 数据
     */
    private T data;

    /**
     * 事件来源
     */
    private String source;

    /**
     * 应用名
     */
    private String appName;

}