package com.gson.test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class RemoveListIfEmpty {

	public static void main(String[] args) {

		String jsonArray = "{\"obj1\":\"xyz\",\"obj2\":\"\",\"obj3\":[{\"a\":\"11\",\"b\":\"21\",\"c\":\"\"},{\"a\":\"54\",\"b\":\"66\",\"c\":\"21\"}],\"obj4\":{\"fname\":\"Rajesh\",\"lname\":\"Kawali\"}}";
		JsonObject jsonObject2 = new Gson().fromJson(jsonArray, JsonObject.class);
		JsonObject innerObj = new JsonObject();
		Map<String, String> testMap = new LinkedHashMap<String, String>();
		JsonArray paymentsArray = jsonObject2.getAsJsonArray("obj3");
		for (JsonElement jsonElement : paymentsArray) {
			//JsonObject jsonObject =jsonElement.getAsJsonObject();
			Set<Entry<String, JsonElement>> elemEntry = ((JsonObject) jsonElement).entrySet();
			Iterator<Entry<String, JsonElement>> itr = elemEntry.iterator();
			while (itr.hasNext()) {
				Entry<String, JsonElement> entry = itr.next();
				JsonElement value = entry.getValue();
				String key = entry.getKey();
				System.out.println(value+"---"+key);
	            testMap.put(entry.getKey(), entry.getValue().getAsString());
				if (testMap.get("c").equals("")) {
		            testMap.clear();
		        }
			}
		}
		String json = new GsonBuilder().setPrettyPrinting().create().toJson(paymentsArray);
		System.out.println(json);
		System.out.println(testMap);
	}
}

/*
 for (Iterator<Map.Entry<String, JsonElement>> it = e1.getAsJsonObject().entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, JsonElement> eIt = it.next();
            JsonElement e2 = eIt.getValue();
            if (e2 == null || e2.isJsonNull()) {
                //it.remove();
            } else if (e2.isJsonArray()) {
                if (e2.getAsJsonArray().size() == 0) {
                    it.remove();
                } else {
                    cleanByTree(e2);
                }
            } else if (e2.isJsonObject()) {
                cleanByTree(e2);
            }
        }
 */
