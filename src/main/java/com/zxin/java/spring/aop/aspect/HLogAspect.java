package com.zxin.java.spring.aop.aspect;

import com.alibaba.fastjson.JSON;
import com.zxin.java.spring.aop.JoinPointBean;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
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
public class HLogAspect {

    @Pointcut("@annotation(com.zxin.java.spring.aop.annotation.HLog)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        IOBean ioBean = new IOBean(joinPoint);
        long start = System.currentTimeMillis();
        try {
            Object returnObj = joinPoint.proceed();
            ioBean.setReturnObj(returnObj);
            ioBean.setDelay(System.currentTimeMillis() - start);
            return returnObj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        } finally {
//            Logger log = LoggerFactory.getLogger(joinPoint.getClass());
            log.info(JSON.toJSONString(ioBean));
        }
    }

    @Data
    private static class IOBean extends JoinPointBean {
        private Object returnObj;
        private long delay;

        public IOBean(JoinPoint joinPoint){
            super(joinPoint);
        }

    }
}
