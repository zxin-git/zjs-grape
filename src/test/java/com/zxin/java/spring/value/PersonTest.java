package com.zxin.java.spring.value;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTest {

	private static final Logger logger = LoggerFactory.getLogger(PersonTest.class);

	@Autowired
	private Person person;
	
	@Test
	public void test() {
		System.out.println(person.toString());
	}

}
