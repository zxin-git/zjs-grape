package com.zxin.java.spring.nacos.registry;

import com.alibaba.nacos.api.naming.NamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

	@Autowired
	private NamingService namingService;

	@RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
	public String echo(@PathVariable String string) {
		System.out.println(namingService);
		return "Hello Nacos Discovery " + string;
	}
}