package com.zxin.java.spring.feign.bank.api;

import com.zxin.java.core.Result;
import feign.Request;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author zxin
 */
@FeignClient(name = "icbc", contextId = "icbc-pay", url = "${feign.client.url.icbc:http://icbc}", path = "/pay")
public interface IcbcPayFeignApi {

    /**
     * 交易接口
     * @return  响应XML
     */
    @PostMapping("/interlink")
    Result<String> interlink(@RequestBody @Valid String xml);

    @PostMapping("/interlink")
    Result<String> interlink1(@RequestBody @Valid String xml, Request.Options options);

}
