package com.jackson.test;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;

// http://www.mkyong.com/java/jackson-streaming-api-to-read-and-write-json/
public class JsonParser {
   @SuppressWarnings("deprecation")
public static void main(String[] args) {

     try {

	JsonFactory jfactory = new JsonFactory();

	/*** read from file ***/
	com.fasterxml.jackson.core.JsonParser jParser = jfactory.createJsonParser(new File("c:\\user.json"));

	// loop until token equal to "}"
	while (jParser.nextToken() != JsonToken.END_OBJECT) {

		String fieldname = jParser.getCurrentName();
		if ("name".equals(fieldname)) {

		  // current token is "name",
                  // move to next, which is "name"'s value
		  jParser.nextToken();
		  System.out.println(jParser.getText()); // display mkyong

		}

		if ("age".equals(fieldname)) {

		  // current token is "age", 
                  // move to next, which is "name"'s value
		  jParser.nextToken();
		  System.out.println(jParser.getIntValue()); // display 29

		}

		if ("messages".equals(fieldname)) {

		  jParser.nextToken(); // current token is "[", move next

		  // messages is array, loop until token equal to "]"
		  while (jParser.nextToken() != JsonToken.END_ARRAY) {

                     // display msg1, msg2, msg3
		     System.out.println(jParser.getText()); 

		  }

		}

	  }
	  jParser.close();

     } catch (JsonGenerationException e) {

	  e.printStackTrace();

     } catch (JsonMappingException e) {

	  e.printStackTrace();

     } catch (IOException e) {

	  e.printStackTrace();

     }

  }

}