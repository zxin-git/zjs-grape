package com.zxin.java.spring.jackson.json;

import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 测试 
 * 序列化 		{@link com.fasterxml.jackson.databind.SerializationFeature}
 * 反序列化	{@link com.fasterxml.jackson.databind.DeserializationFeature}
 * 			{@link com.fasterxml.jackson.databind.MapperFeature}
 * @author zxin
 *
 */
public class MapperFeature {

	private static final Logger logger = LoggerFactory.getLogger(MapperFeature.class);

	protected ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void serialize(){
		User user = new User(1, "zxin", true);
		try {
			logger.info(mapper.enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(user));
			logger.info(mapper.writeValueAsString(user));
			
			logger.info(mapper.writer().without(SerializationFeature.INDENT_OUTPUT).writeValueAsString(user));
			logger.info(mapper.writer().writeValueAsString(user));
		} catch (JsonProcessingException e) {
			logger.warn("", e);
		}
	}
	
	@Test
	public void deserialize(){
		String json = "{\"id\":1,\"name\":\"zxin\",\"sex\":true}";
		try {
			logger.info(mapper.readValue(json, User.class).toString());
			
			logger.info(mapper.readerFor(User.class).readValue(json).toString());
		} catch (IOException e) {
			logger.warn("", e);
		}
	}
	
}
