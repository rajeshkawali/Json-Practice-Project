package com.jackson.test;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToJava {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "{'name' : 'Rajesh'}";

		//JSON from file to Object
		User user = mapper.readValue(new File("c:\\user.json"), User.class);

		//JSON from String to Object
		User user2 = mapper.readValue(jsonInString, User.class);

	}

}
