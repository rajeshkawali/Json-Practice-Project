package com.gson.test;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
// Convert a JSON Array to a List, using TypeToken
public class JsonArayToList {

	public static void main(String[] args) {
		Gson gson = new Gson();
		String json = "[{\"name\":\"Rajesh\"}, {\"name\":\"Arjun\"}]";
		List<Staff> list = gson.fromJson(json, new TypeToken<List<Staff>>(){}.getType());
		list.forEach(x -> System.out.println(x));
	}
}
