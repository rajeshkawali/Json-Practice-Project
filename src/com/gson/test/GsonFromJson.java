package com.gson.test;

import com.google.gson.Gson;
//https://zetcode.com/java/gson/
class User {

	private String firstName;
	private String lastName;

	public User() {
	}

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("User{").append("First name: ").append(firstName).append(", Last name: ")
				.append(lastName).append("}").toString();
	}

}

public class GsonFromJson {

	public static void main(String[] args) {

		String json_string = "{\"firstName\":\"Tom\", \"lastName\": \"Broody\"}";

		Gson gson = new Gson();
		User user = gson.fromJson(json_string, User.class);

		System.out.println(user);
	}
}