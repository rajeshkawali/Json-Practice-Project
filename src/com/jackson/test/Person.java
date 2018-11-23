package com.jackson.test;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

// @JsonInclude(Include.NON_EMPTY) // any property of this class having empty value will not be included in JSON. 
// @JsonInclude(Include.NON_NULL) // any property of this class having null value will not be included in JSON. 
public class Person {
	
	// indicates that property is serialized if its value is not null and not empty.
	@JsonInclude(JsonInclude.Include.NON_EMPTY)  
	public String firstName;
	// indicates that property is serialized if its value is not null.
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String lastName;
	public int age;
	public Date dob;

	public Person() {
	}

	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Person(String firstName, String lastName, Date dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}

	public String toString() {
		return "[" + firstName + " " + lastName + " " + age + "]";
	}
}