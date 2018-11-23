package com.jackson.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class ArrayOfArray {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode array = mapper.createArrayNode();
		int i = 0;
		while (i < 6) {
			array.add(mapper.createArrayNode().add("" + i++).add("" + i++));
		}
		System.out.println(array);
	}
}
