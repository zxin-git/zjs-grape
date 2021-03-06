package com.zxin.java.spring.value;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileObjectTest {

	private static final Logger logger = LoggerFactory.getLogger(FileObjectTest.class);

	@Autowired
	private FileObject fo;
	
	@Test
	public void test() {
		System.out.println(fo);
	}

}
