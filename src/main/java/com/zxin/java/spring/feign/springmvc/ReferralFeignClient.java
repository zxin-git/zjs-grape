package com.zxin.java.spring.feign.springmvc;

import com.zxin.java.spring.feign.springmvc.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * bus event
 */
@FeignClient(name = "uke-referral", url = "http://10.111.182.166:8080")
public interface ReferralFeignClient {

    @PostMapping("/referral/relation/list")
    Result<String> list(ReferralQuery referralQuery);


}