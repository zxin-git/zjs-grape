package org.springframework.core.env;

/**
 * @author zxin
 */
public class StandardEnvironmentTest {

    public static void main(String[] args) {
        StandardEnvironment environment = new StandardEnvironment();
        String a = environment.getProperty("java.home");
        System.out.println(a);
    }

}
