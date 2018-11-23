package com.gson.test;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GsonExample {

	public static void main(String[] args) {
		Staff staff = createDummyObject();
		// 1. Convert object to JSON string
		Gson gson = new Gson();
		String json = gson.toJson(staff);
		System.out.println(json);
		// 2. Convert object to JSON string and save into a file directly
		try (FileWriter writer = new FileWriter("c:\\staff.json")) {
			gson.toJson(staff, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Staff createDummyObject() {
		Staff staff = new Staff();
		staff.setName("Rajesh");
		staff.setAge(30);
		staff.setPosition("Developer");
		staff.setSalary(new BigDecimal("10000"));
		List<String> skills = new ArrayList<>();
		skills.add("java");
		skills.add("spring");
		skills.add("hibernate");
		staff.setSkills(skills);
		return staff;
	}
}