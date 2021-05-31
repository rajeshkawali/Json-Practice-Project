package com.gson.test;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
//https://zetcode.com/java/gson/
public class GsonPrettyPrinting {

    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        Map<String, Integer> items = new HashMap();
        
        items.put("chair", 3);
        items.put("pencil", 1);
        items.put("book", 5);

        gson.toJson(items, System.out);
    }
}