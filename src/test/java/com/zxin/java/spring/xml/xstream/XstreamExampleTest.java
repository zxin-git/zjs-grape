package com.zxin.java.spring.xml.xstream;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XstreamExampleTest {

	private static final Logger logger = LoggerFactory.getLogger(XstreamExampleTest.class);

//	private static XStream xstream = new XStream();
	
	@Test
	public void test() {
		Map<String, String> map = new HashMap<>();
		map.put("sdfsaf", "aaa");
		map.put("cccc", "222");
		map.put("dddd", "333");
		map.put("ffff", "sadfsd");
		
		
//		System.out.println(xstream.toXML(map));
	}

}
