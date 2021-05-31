package com.jackson.test;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JacksonTraverse {

	public static void main(String[] args) throws IOException {

		
		
		//Resource resource = new ClassPathResource("gateway-fields.json");  //read from json file
		String jsonArray = "{\"obj0\":\"Rajesh\",\"obj1\":{\"fname\":\"Rajesh\",\"lname\":\"Kawali\"},\"obj2\":[{\"name1\":\"val1\",\"name2\":\"val2\"},{\"name3\":\"val3\",\"name4\":\"val4\"}]}";

	      JsonFactory jsonFactory = new JsonFactory();
	      ObjectMapper objectMapper = new ObjectMapper(jsonFactory);
	      ObjectMapper mapper = new ObjectMapper();

	      String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);
	      JsonNode arrayNode = objectMapper.readTree(jsonInString).get("obj0");

	      if (arrayNode.isArray()) {
	          for (JsonNode jsonNode : arrayNode) {
	              String nameFieldNode = jsonNode.get("obj2").asText();    
	              if("name1".equals(nameFieldNode)){
	                     ((ObjectNode)jsonNode).put("name1", "1112");
	                     System.out.println(jsonNode);
	              }
	          }
	      }
	      //System.out.println(jsonNode);
	}

}
