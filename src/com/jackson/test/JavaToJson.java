package com.jackson.test;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJson {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		User user = new User();

		//Object to JSON in file
		mapper.writeValue(new File("c:\\user.json"), user);

		//Object to JSON in String
		String jsonInString = mapper.writeValueAsString(user);
		System.out.println(jsonInString);

	}

}
