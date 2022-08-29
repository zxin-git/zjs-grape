package com.zxin.java.spring.feign.bank.api;

import com.zxin.java.core.Result;
import com.zxin.java.spring.feign.bank.CcbFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author zxin
 */
@FeignClient(name = "ccb", contextId = "ccb-pay", url = "${feign.client.url.ccb:http://ccb}", path = "/pay", configuration = CcbFeignConfiguration.class)
public interface CcbPayFeignApi {

    /**
     * 交易接口
     * @return  响应XML
     */
    @PostMapping("/interlink")
    Result<String> interlink(@RequestBody @Valid String xml);

}
