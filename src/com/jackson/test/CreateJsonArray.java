package com.jackson.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CreateJsonArray {

	public static void main(String[] args) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		ArrayNode array = mapper.createArrayNode();
		JsonNode rootNode = mapper.createObjectNode();
				
		JsonNode childNode = mapper.createObjectNode();
		((ObjectNode) childNode).put("fname", "Rajesh");
		((ObjectNode) childNode).put("lname", "Kawali");
		
		((ObjectNode) rootNode).put("obj0", "Rajesh");
		((ObjectNode) rootNode).set("obj1", childNode);
		
		JsonNode childNode1 = mapper.createObjectNode();
		((ObjectNode) childNode1).put("name1", "val1");
		((ObjectNode) childNode1).put("name2", "val2");
		
		array.add(childNode1);
		
		JsonNode childNode2 = mapper.createObjectNode();
		((ObjectNode) childNode2).put("name3", "val3");
		((ObjectNode) childNode2).put("name4", "val4");

		((ObjectNode) rootNode).set("obj2", array.add(childNode2));
		
		String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
		System.out.println(jsonString);
		
	}

}
