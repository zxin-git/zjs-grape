package com.zxin.java.spring.feign.bank.api;

import com.zxin.java.core.Result;
import com.zxin.java.spring.AbstractBootApplicationTest;
import feign.Request;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

class CcbPayFeignApiTest extends AbstractBootApplicationTest {

    @Autowired
    private CcbPayFeignApi ccbPayFeignApi;

    @Autowired
    private IcbcPayFeignApi icbcPayFeignApi;

    @Test
    void interlink() {
        Request.Options options = new Request.Options(1,  5,  true);
        Result<String> result = icbcPayFeignApi.interlink1("xml", options);
        System.out.println(result);
    }
}