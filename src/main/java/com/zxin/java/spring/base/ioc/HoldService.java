package com.zxin.java.spring.base.ioc;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zxin
 */
@Data
@Service
public class HoldService {

    /**
     * 会报错：
     * Bean named 'config' is expected to be of type 'com.zxin.java.spring.base.ioc.IOCConfig'
     * but was actually of type 'com.zxin.java.spring.base.ioc.Config'
     */
//    @Resource
//    private IOCConfig config;

    @Resource
    private IOCConfig iocConfig;

}
