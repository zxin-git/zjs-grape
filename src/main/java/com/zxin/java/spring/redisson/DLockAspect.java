package com.zxin.java.spring.redisson;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zxin
 */
@Aspect
@Component
public class DLockAspect {

    @Autowired
    private RedissonClient redisson;

    private SpelExpressionParser spelParser = new SpelExpressionParser();
    private LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();


    @Pointcut("@annotation(com.zxin.java.spring.redisson.DLock)")
    public void pointcut(){}

    @Around("@annotation(dLock)")
    public Object around(ProceedingJoinPoint joinPoint, DLock dLock) throws Throwable{
        String name = name(joinPoint, dLock);
        RLock lock = redisson.getLock(name);
//        boolean acquired = lock.tryLock(10, 10, TimeUnit.SECONDS);
//        if(acquired){
            try {
                lock.lock();
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                throw throwable;
            } finally {
                lock.unlock();
            }
//        } else {
//            throw new DLockException(String.format("获取锁异常[%s]", name));
//        }

    }

    private String name(ProceedingJoinPoint joinPoint, DLock dLock){
        String spel = dLock.value();
        Object[] args = joinPoint.getArgs();
        joinPoint.getSignature();

        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        String[] params = discoverer.getParameterNames(method);
        EvaluationContext context = new StandardEvaluationContext();
        for (int len = 0; len < params.length; len++) {
            context.setVariable(params[len], args[len]);
        }
        Expression expression = spelParser.parseExpression(spel);
        return expression.getValue(context, String.class);
    }

}
