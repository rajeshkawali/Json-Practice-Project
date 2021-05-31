package com.gson.test;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonParserExample {

    public static void main(String[] args) {
        String jsonString = "{ \"name\":\"John\"}";

        JsonObject jsonObjectAlt = JsonParser.parseString(jsonString).getAsJsonObject();//Alternate parser
        // Shows deprecated warning for new JsonParser() and parse(jsonString)
        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject(); //deprecated

        //assertTrue(jsonObjectAlt.equals(jsonObject));

    }
}