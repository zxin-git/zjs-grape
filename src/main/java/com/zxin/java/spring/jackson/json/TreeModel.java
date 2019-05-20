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
	

	
	public static void main(String[] args) {
		try {
			//创建一个节点工厂,为我们提供所有节点  
			JsonNodeFactory factory = new JsonNodeFactory(false);  
			//创建一个json factory来写tree modle为json  
			JsonFactory jsonFactory = new JsonFactory();  
			//创建一个json生成器  
			JsonGenerator generator = jsonFactory.createGenerator(new FileWriter(new File("country2.json")));  
			//注意，默认情况下对象映射器不会指定根节点，下面设根节点为country  
			ObjectMapper mapper = new ObjectMapper();  
			ObjectNode country = factory.objectNode();  
			  
			country.put("country_id", "China");  
			country.put("birthDate", "1949-10-01");  
			  
			//在Java中，List和Array转化为json后对应的格式符号都是"obj:[]"  
			ArrayNode nation = factory.arrayNode();  
			nation.add("Han").add("Meng").add("Hui").add("WeiWuEr").add("Zang");  
			country.set("nation", nation);  
			  
			ArrayNode lakes = factory.arrayNode();  
			lakes.add("QingHai Lake").add("Poyang Lake").add("Dongting Lake").add("Taihu Lake");  
			country.set("lakes", lakes);  
			  
			ArrayNode provinces = factory.arrayNode();  
			ObjectNode province = factory.objectNode();  
			ObjectNode province2 = factory.objectNode();  
			province.put("name","Shanxi");  
			province.put("population", 37751200);  
			province2.put("name","ZheJiang");  
			province2.put("population", 55080000);  
			provinces.add(province).add(province2);  
			country.set("provinces", provinces);  
			  
			ObjectNode traffic = factory.objectNode();  
			traffic.put("HighWay(KM)", 4240000);  
			traffic.put("Train(KM)", 112000);  
			country.set("traffic", traffic);  
			  
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);  
			mapper.writeTree(generator, country);
			
//      	ObjectMapper mapper = new ObjectMapper();  
			JsonNode node = mapper.readTree(new File("country2.json"));
		} catch (IOException e) {
			logger.warn("", e);
		} 
	}
}
