package com.zxin.java.spring.jackson.json;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.SerializationFeature;

public class TreeModelTest extends TreeModel {

	private static final Logger logger = LoggerFactory.getLogger(TreeModelTest.class);


	@Test
	public void testBuild() {
		System.out.println(generator(build()));
	}

	@Test
	public void testResolve() {
		resolve(parse(generator(build())));
	}

}
