package com.zxin.java.spring.feign.springmvc;

import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import lombok.Data;
import org.slf4j.MDC;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * MDC策略
 *
 * <p>需加入配置hystrix.plugin.HystrixConcurrencyStrategy.implementation = com.zhangmen.uke.referral.infrastructure.interceptor.HystrixConcurrencyStrategyMDC</p><br/>
 * <p>com.netflix.hystrix.strategy.HystrixPlugins#getConcurrencyStrategy()</p>
 * @author zxin
 */
public class HystrixConcurrencyStrategyMDC extends HystrixConcurrencyStrategy {

    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        WrappedCallable<T> wrappedCallable = new WrappedCallable<>(callable);
        wrappedCallable.setRequestAttributes(RequestContextHolder.getRequestAttributes());
        wrappedCallable.setContextMap(MDC.getCopyOfContextMap());
        return wrappedCallable;
    }

    @Data
    static class WrappedCallable<T> implements Callable<T> {
        private Callable<T> target;
        private RequestAttributes requestAttributes;
        private Map<String, String> contextMap;

        public WrappedCallable(Callable<T> target){
            this.target = target;
        }

        @Override
        public T call() throws Exception {
            try {
                RequestContextHolder.setRequestAttributes(requestAttributes);
                MDC.setContextMap(contextMap);
                return target.call();
            } finally {
                RequestContextHolder.resetRequestAttributes();
                MDC.clear();
            }
        }
    }

}
