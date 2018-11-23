package com.jackson.test;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class JsonGenerator {
	public static void main(String[] args) {

		try {
			JsonFactory jfactory = new JsonFactory();
			com.fasterxml.jackson.core.JsonGenerator jGenerator = jfactory.createGenerator(new File("c:\\user.json"),JsonEncoding.UTF8);
			jGenerator.writeStartObject(); // {
			jGenerator.writeStringField("name", "Rajesh"); // "name" : "Rajesh"
			jGenerator.writeNumberField("age", 29); // "age" : 29
			jGenerator.writeFieldName("messages"); // "messages" :
			jGenerator.writeStartArray(); // [
			jGenerator.writeString("msg 1"); // "msg 1"
			jGenerator.writeString("msg 2"); // "msg 2"
			jGenerator.writeString("msg 3"); // "msg 3"
			jGenerator.writeEndArray(); // ]
			jGenerator.writeEndObject(); // }
			jGenerator.close();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}