package com.zxin.java.spring.aop;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

/**
 * @author zxin
 */

@Data
@NoArgsConstructor
public class JoinPointBean {

    private String className;

    private String methodName;

    private Object[] args;


    public JoinPointBean(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        this.className = signature.getDeclaringTypeName();
        this.methodName = signature.getName();
        this.args = joinPoint.getArgs();
    }

}
