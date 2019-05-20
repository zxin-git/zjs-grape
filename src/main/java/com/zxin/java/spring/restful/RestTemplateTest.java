package com.zxin.java.spring.restful;

import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", String.class));
	}
}

