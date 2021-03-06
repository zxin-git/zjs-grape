package com.zxin.java.spring.base.spel;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author zxin
 */
@Slf4j
public class SPELExample {


    @Test
    public void textHello(){
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'hello world'");
        String message = expression.getValue(String.class);
        log.info(message);
    }
}
