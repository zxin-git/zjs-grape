package com.zxin.java.spring.feign.springmvc;


import com.zxin.java.spring.feign.springmvc.result.Result;
import feign.hystrix.FallbackFactory;
import lombok.AllArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * bus event
 */
@FeignClient(name = "bus", fallbackFactory = BusFeignClient.BusFeignClientFallBackFactory.class)
public interface BusFeignClient {

    @PostMapping("/push")
    <T> Result<String> pushNoticeMsg(BusPushNoticeReq<T> busPushNoticeReq);

    @PostMapping("/push/sys")
    <T> Result<String> pushSysMsg(BusSysPushReq<T> busSysPushReq);

    @Component
    class BusFeignClientFallBackFactory implements FallbackFactory<BusFeignClient>{

        @Override
        public BusFeignClient create(Throwable cause) {
            return new BusFeignClientFallbackImpl(cause);
        }
    }

    @AllArgsConstructor
    class BusFeignClientFallbackImpl implements BusFeignClient {

        private Throwable cause;

        @Override
        public <T> Result<String> pushNoticeMsg(BusPushNoticeReq<T> busPushNoticeReq) {
            return FeignUtils.fallBackResult(cause);
        }

        @Override
        public <T> Result<String> pushSysMsg(BusSysPushReq<T> busSysPushReq) {
            return FeignUtils.fallBackResult(cause);
        }

    }

}