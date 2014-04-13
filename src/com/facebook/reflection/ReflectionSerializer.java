package com.facebook.reflection;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.facebook.Response;

public class ReflectionSerializer {

	public static ArrayList<String> parse(Response response) {
		ArrayList<String> result = new ArrayList<String>();
		JSONObject arr = response.getGraphObject().getInnerJSONObject();
		JSONArray data = arr.optJSONArray("data");
		int size = data.length();
		for (int i=0; i<size; i++) {
			JSONObject obj;
			try {
				obj = (JSONObject) data.get(i);
				result.add(obj.optString("message"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		Log.i("VITHUSHAN", data.toString());
		return result;
	}

}
