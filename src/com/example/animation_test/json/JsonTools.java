package com.example.animation_test.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonTools {

	public JsonTools() {
		// TODO Auto-generated constructor stub
	}
	public List<String> parseList(String result){
		List<String> list = new ArrayList<String>();
		try {
			JSONObject jsonObject = new JSONObject(result);
			String json = jsonObject.getString("serverinfo");
			jsonObject = new JSONObject(json);
			Iterator<String> iterator = jsonObject.keys();
			while(iterator.hasNext()){
				String key = iterator.next();
				String value = jsonObject.getString(key);
				list.add(value);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
