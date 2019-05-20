package com.zxin.java.spring.lombok;

import org.junit.Test;

/**
 * 需加入编译插件，防止eclipse提示报错
 * @author zxin
 *
 */
public class UserTest {

	@Test
	public void test(){
		User user = new User();
		user.setId("1");
		user.setName("name");
		System.out.println(user.toString());
	}

}
