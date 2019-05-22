package com.zxin.java.spring.cache.key;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

/**
 * 自定义key序列化
 * @author zxin
 *
 */
@Component
public class CustomKeyGenerator implements KeyGenerator{

	private static final Logger logger = LoggerFactory.getLogger(CustomKeyGenerator.class);

	@Override
	public Object generate(Object target, Method method, Object... params) {
		return target.getClass().getSimpleName() + ":" + method.getName() + ":" + generateKey(params);
	}

	/**
	 * Generate a key based on the specified parameters.
	 */
	public static Object generateKey(Object... params) {
		if (params.length == 0) {
			return "";
		}
		if (params.length == 1) {
			Object param = params[0];
			if (param != null && !param.getClass().isArray()) {
				return param;
			}
		}
		return StringUtils.join(Arrays.asList(params),"_");
	}
}
