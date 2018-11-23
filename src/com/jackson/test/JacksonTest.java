package com.jackson.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JacksonTest {

	public static void main(String[] args) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.createObjectNode();

		JsonNode childNode1 = mapper.createObjectNode();
		((ObjectNode) childNode1).put("name1", "val1");
		((ObjectNode) childNode1).put("name2", "val2");

		((ObjectNode) rootNode).set("obj1", childNode1);

		JsonNode childNode2 = mapper.createObjectNode();
		((ObjectNode) childNode2).put("name3", "val3");
		((ObjectNode) childNode2).put("name4", "val4");

		((ObjectNode) rootNode).set("obj2", childNode2);

		JsonNode childNode3 = mapper.createObjectNode();
		((ObjectNode) childNode3).put("name5", "val5");
		((ObjectNode) childNode3).put("name6", "val6");

		((ObjectNode) rootNode).set("obj3", childNode3);

		String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
		System.out.println(jsonString);

	}

}
