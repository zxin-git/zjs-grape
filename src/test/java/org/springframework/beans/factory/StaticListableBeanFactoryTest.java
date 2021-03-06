package org.springframework.beans.factory;

import org.junit.Test;
import org.springframework.beans.factory.support.StaticListableBeanFactory;

/**
 * @author zxin
 */
public class StaticListableBeanFactoryTest {

    @Test
    public void test(){
        StaticListableBeanFactory beanFactory = new StaticListableBeanFactory();
        System.out.println(beanFactory);
    }

}
