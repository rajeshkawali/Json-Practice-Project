package com.gson.test;
import java.io.IOException;
import java.io.PrintStream;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//https://zetcode.com/java/gson/
class User2 {
    
    private final String firstName;
    private final String lastName;

    public User2(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

public class GsonBuilderEx {

    public static void main(String[] args) throws IOException {

        try {
        	PrintStream prs = new PrintStream(System.out, true, "UTF8");
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            
            User2 user = new User2("Peter", "Flemming");
            gson.toJson(user, prs);
        }
        catch (Exception e) {
		}
    }
}