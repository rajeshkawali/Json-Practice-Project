package com.gson.test;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

public class JavaToJson {

	public static void main(String[] args) {

		Gson gson = new Gson();
		Staff obj = new Staff();

		// 1. Java object to JSON, and save into a file
		try {
			gson.toJson(obj, new FileWriter("c:\\staff.json"));
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 2. Java object to JSON, and assign to a String
		String jsonInString = gson.toJson(obj);
		System.out.println(jsonInString);

	}

}
