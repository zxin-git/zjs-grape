package com.zxin.java.spring.aop.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.zxin.java.spring.aop.JoinPointBean;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * @author zxin
 */
@Slf4j
@Aspect
@Component
public class StopWatchAspect {

    @Pointcut("@annotation(com.zxin.java.spring.aop.annotation.StopWatch) && @annotation(com.zxin.java.spring.aop.annotation.HLog)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        StopWatchBean stopWatchBean = new StopWatchBean(joinPoint);
        stopWatchBean.start();
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        } finally {
            stopWatchBean.stop();
            log.info(JSON.toJSONString(stopWatchBean));
        }
    }

    @Data
    public static class StopWatchBean extends JoinPointBean{
        private long delay;

        @JSONField(serialize = false)
        private StopWatch stopWatch = new StopWatch();

        public StopWatchBean(JoinPoint joinPoint){
            super(joinPoint);
        }

        public void start(){
            stopWatch.start();
        }

        public void stop(){
            stopWatch.stop();
            delay = stopWatch.getTime();
        }

    }


}
