package com.jackson.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class CallMe {
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

class Staff {

	private String name;
	private int age;
	private CallMe calMe;
	
	public CallMe getCalMe() {
		return calMe;
	}
	public void setCalMe(CallMe calMe) {
		this.calMe = calMe;
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
}

public class Calender {

	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();
		Staff staff = new Staff();
		CallMe cal = new CallMe();
		staff.setName("Rajesh");
		staff.setAge(10);
		cal.setS1("Ram");
		cal.setS2("Raj");
		staff.setCalMe(cal);
		String arrayToJson = null;
		try {
			arrayToJson = objectMapper.writeValueAsString(staff);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(arrayToJson);
	}
}
