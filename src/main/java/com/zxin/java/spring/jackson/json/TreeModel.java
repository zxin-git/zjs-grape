package com.zxin.java.spring.jackson.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 
 * @author zxin
 *
 */
public class TreeModel {

	private static final Logger logger = LoggerFactory.getLogger(TreeModel.class);
	
	protected ObjectMapper mapper = new ObjectMapper(); 
	
	/**
	 * 将树节点 转成 json
	 * @return
	 */
	public String generator(JsonNode rootNode){
		StringWriter writer = new StringWriter();
		try {
			JsonFactory jsonFactory = new JsonFactory(); 
			JsonGenerator generator = jsonFactory.createGenerator(writer);
			mapper.writeTree(generator, rootNode);
		} catch (IOException e) {
			logger.warn("", e);
		}
		return writer.toString();
	}
	
	/**
	 * 解析json 为 树节点
	 * @param json
	 * @return
	 */
	public JsonNode parse(String json){
		JsonNode rootNode = null;
		try {
			rootNode = mapper.readTree(json);
		} catch (IOException e) {
			logger.warn("", e);
		}
		return rootNode;
	}
	
	/**
	 * 构建tree的 jsonNode
	 * 1. 普通类型   						put()
	 * 2. 对象或数组 (JsonNode或ArrayNode)   set()
	 * 3. 数组内项							add()
	 * @return
	 */
	public JsonNode build(){
		JsonNodeFactory factory = new JsonNodeFactory(false);
		ObjectNode country = factory.objectNode();
		
		country.put("country_id", "China");  //普通类型
		country.put("birthDate", "1949-10-01").put("time", 8).put("develop", true);  
		
		ObjectNode traffic = factory.objectNode();  //node对象
		traffic.put("HighWay(KM)", 4240000);  
		traffic.put("Train(KM)", 112000);  
		country.set("traffic", traffic);
		
		ArrayNode lakes = factory.arrayNode();  // 普通数组
		lakes.add("QingHai Lake").add("Poyang Lake").add("Dongting Lake").add("Taihu Lake");  
		country.set("lakes", lakes);
		
		
		ObjectNode shanxi = factory.objectNode();  //node数组
		shanxi.put("name","Shanxi");  
		shanxi.put("population", 37751200);  
		ObjectNode zhejiang = factory.objectNode();  
		zhejiang.put("name","ZheJiang");  
		zhejiang.put("population", 55080000);  
		ArrayNode provinces = factory.arrayNode();  
		provinces.add(shanxi).add(zhejiang);  
		country.set("provinces", provinces);
		
		return country;
	}
	
	
	public void resolve(JsonNode jsonNode){
		System.out.println(jsonNode.path("provinces").path(0).path("name").asText());
	}
	

}
