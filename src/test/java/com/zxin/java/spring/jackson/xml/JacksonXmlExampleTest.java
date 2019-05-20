package com.zxin.java.spring.jackson.xml;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JacksonXmlExampleTest {

	private static final Logger logger = LoggerFactory.getLogger(JacksonXmlExampleTest.class);

	private Map<String, String> map;
	
//	@Test
//	public void test() {
//		try {
//			XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
//			XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
//			StringWriter out = new StringWriter();
//			XMLStreamWriter sw = xmlOutputFactory.createXMLStreamWriter(out);
//			
//			XmlMapper mapper = new XmlMapper(xmlInputFactory);
//			
//			String xml = "<request><funcode>Gcs6000013</funcode><datetime>20190429000001</datetime><merid>01601002</merid><transid>153773813121012</transid></request>";
//			
//			map = mapper.readValue(xml, new TypeReference<Map<String, String>>() {});
//			map.entrySet().stream().forEach(System.out::println);
//			
//			sw.writeStartDocument("UTF-8", "1.0");
//			sw.writeStartElement("request");
//			map.entrySet().stream().forEach((entry) ->{
//				try {
//					sw.writeStartElement(entry.getKey());
//					sw.writeCharacters(entry.getValue());
//					sw.writeEndElement();
//				} catch (XMLStreamException e) {
//					logger.warn("", e);
//				}
//			});
//			sw.writeEndElement();
//			sw.writeEndDocument();
//			
////			String val = mapper.writeValueAsString(map);
//			System.out.println(out.toString());
//		} catch (IOException | XMLStreamException e) {
//			logger.warn("", e);
//		}
//	}

}
