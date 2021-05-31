package com.gson.test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//https://zetcode.com/java/gson/
public class GsonTreeModelRead {

	public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String fileName = "src/main/resources/cars.json";
        Path path = Paths.get(fileName);

        try {
        	Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            JsonParser parser = new JsonParser();
            JsonElement tree = parser.parse(reader);

            JsonArray array = tree.getAsJsonArray();

            for (JsonElement element : array) {

                if (element.isJsonObject()) {

                    JsonObject car = element.getAsJsonObject();

                    System.out.println("********************");
                    System.out.println(car.get("name").getAsString());
                    System.out.println(car.get("model").getAsString());
                    System.out.println(car.get("price").getAsInt());

                    JsonArray cols = car.getAsJsonArray("colours");
                    
                    for (JsonElement elem : cols) {
                    	System.out.println(elem.getAsString());
                    }
                    //System.out.println(cols.iterator().hasNext());
                    
					/*
					 * cols.forEach(col -> { System.out.println(col); });
					 */
                }
            }
        }finally {
			
		}
    }
}


/*

cars.json -->

[{"name":"Audi","model":"2012","price":22000,"colours":["gray","red","white"]},
 {"name":"Skoda","model":"2009","price":14000,"colours":["black","gray","white"]},
 {"name":"Volvo","model":"2010","price":19500,"colours":["black","silver","beige"]}]


*/