package com.zxin.java.spring.jackson.json;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TreeModelTest extends TreeModel {

//	private static final Logger logger = LoggerFactory.getLogger(TreeModelTest.class);


	@Test
	public void testBuild() {
		System.out.println(generator(build()));
	}

	@Test
	public void testResolve() {
		resolve(parse(generator(build())));
	}

}
