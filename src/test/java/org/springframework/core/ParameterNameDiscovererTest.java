package org.springframework.core;

import java.lang.reflect.Method;
import java.util.Locale;

/**
 * @author zxin
 */
public class ParameterNameDiscovererTest {

    public static void main(String[] args) {
//        ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
        ParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        Method[] methods = ParameterNameDiscovererTest.class.getMethods();
        String[] params = parameterNameDiscoverer.getParameterNames(methods[0]);
        System.out.println(params);
    }
}
