package com.jackson.test;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JSONListConverter2
{
    @SuppressWarnings("rawtypes")
	public static void main( String[] args ) throws IOException
    {
    	ObjectMapper objectMapper = new ObjectMapper();
    	//Set pretty printing of json
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

    	//List of person objects which will be converted to JSON
    	List personList = Stream.of(
					new Person("Mike", "harvey", 34),
				  	new Person()
			  	)
				.collect(Collectors.toList());
    	
    	//1. Convert List Person to JSON (Serializing null values)
    	String arrayToJson = objectMapper.writeValueAsString(personList);
    	System.out.println("1. Convert List of person object to JSON (Serializing null values) :");
    	System.out.println(arrayToJson);    	
    	
    	//ObjectMapper for not serializing null values
    	objectMapper = new ObjectMapper();
    	//Set pretty printing of json
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	//Setting the serializing feature: do not serialize null values
    	objectMapper.setSerializationInclusion(Include.NON_NULL);
    	arrayToJson = objectMapper.writeValueAsString(personList);
    	System.out.println("2. Convert List of person object to JSON  (do not Serializing null values):");
    	System.out.println(arrayToJson);  
    }
}