package com.zxin.java.spring.feign.springmvc;

import com.zxin.java.spring.feign.springmvc.result.Result;
import com.zxin.java.spring.feign.springmvc.result.ResultUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zxin
 */
@Slf4j
public class FeignUtils {

    public static <T> Result<T> fallBackResult(Throwable cause){
        log.warn("feign调用异常", cause);
        return ResultUtils.errorFeignResult();
    }

}
