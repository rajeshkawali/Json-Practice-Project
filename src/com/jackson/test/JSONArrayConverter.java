package com.jackson.test;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JSONArrayConverter 
{
    public static void main( String[] args ) throws IOException
    {
    	ObjectMapper objectMapper = new ObjectMapper();
    	//Set pretty printing of json
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

    	//Define map which will be converted to JSON
    	Person[] personList = Stream.of(
				new Person("Rajesh", "Kawali", 30),
			  	new Person("Arjun", "Gangaram", 32),
				new Person("Jack", "slater", 21 ),
				new Person("gary", "hudson", 55))
				.toArray(Person[]::new);
    	
    	//1. Convert Array to JSON
    	String arrayToJson = objectMapper.writeValueAsString(personList);
    	System.out.println("1. Convert Array to JSON :");
    	System.out.println(arrayToJson);
    	
    	//2. JSON to Array
    	//Define Custom Type reference for map type
    	Person[] jsonToArray = objectMapper.readValue(arrayToJson, Person[].class);
    	System.out.println("\n2. Convert JSON to Array :");
    	
    	//Print array output using Java 8
    	Arrays.stream(jsonToArray).forEach(System.out::println);
    }
}