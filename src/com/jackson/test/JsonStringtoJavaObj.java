package com.jackson.test;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
// http://www.mkyong.com/java/how-to-convert-java-object-to-from-json-jackson/
public class JsonStringtoJavaObj {
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// Convert JSON string from file to Object
			User user = mapper.readValue(new File("c:\\user.json"), User.class);
			System.out.println(user);
			// Convert JSON string to Object
			String jsonInString = "{\"age\":33,\"messages\":[\"msg 1\",\"msg 2\"],\"name\":\"Rajesh\"}";
			User user1 = mapper.readValue(jsonInString, User.class);
			System.out.println(user1);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}