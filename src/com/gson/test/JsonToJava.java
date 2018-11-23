package com.gson.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class JsonToJava {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		
		Gson gson = new Gson();
		// 1. JSON to Java object, read it from a file.
		Staff staff = gson.fromJson(new FileReader("c:\\file.json"), Staff.class);
		// 2. JSON to Java object, read it from a Json String.
		String jsonInString = "{'name' : 'Rajesh'}";
		Staff staff2 = gson.fromJson(jsonInString, Staff.class);
		// JSON to JsonElement, convert to String later.
		JsonElement json = gson.fromJson(new FileReader("c:\\file.json"), JsonElement.class);
	    String result = gson.toJson(json);
	}
}
