package com.jackson.test;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class CalClass {
	private String s1;
	private String s2;
	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
}

class StaffClass {
	private String name;
	private int age;
	private List<String> skills;
	private CallMe cc;
	public CallMe getCc() {
		return cc;
	}
	public void setCc(CallMe cal) {
		this.cc = cal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
}

public class Test {

	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();
		StaffClass staff = new StaffClass();
		CallMe cal = new CallMe();
		staff.setName("Rajesh");
		staff.setAge(33);
		List<String> skills1 = new ArrayList<>();
		skills1.add("java");
		skills1.add("python");
		staff.setSkills(skills1);
		cal.setS1("Ram");
		cal.setS2("Raj");
		staff.setCc(cal);
		String arrayToJson = null;
		try {
			arrayToJson = objectMapper.writeValueAsString(staff);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(arrayToJson);
	}
}
