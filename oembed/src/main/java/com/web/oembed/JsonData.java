package com.web.oembed;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JsonData {

    public JsonData() {

    }
    public Map<String, Object> json (String data) throws JSONException {
        System.out.println("data = " + data);
        int html = data.indexOf(",\"html\"");
        int lastDot = data.lastIndexOf("\"");
        data=data.substring(0,html)+"}";
        Map<String, Object> jsArr = youtubeGetJsonObject(data);
        return jsArr;
    }

    private Map<String, Object> youtubeGetJsonObject(String data) throws JSONException {
        System.out.println(data);
        JSONObject jObject = new JSONObject(data);
        System.out.println(jObject);

        Map<String, Object> resultMap = new HashMap();
        resultMap.put("title", jObject.getString("title"));
        resultMap.put("author_name", jObject.getString("author_name"));
        resultMap.put("author_url", jObject.getString("author_url"));
        resultMap.put("type", jObject.getString("type"));
        resultMap.put("height", jObject.getInt("height"));
        resultMap.put("width", jObject.getInt("width"));
        resultMap.put("version", jObject.getString("version"));
        resultMap.put("provider_name", jObject.getString("provider_name"));
        resultMap.put("provider_url", jObject.getString("provider_url"));
        resultMap.put("thumbnail_height", jObject.getInt("thumbnail_height"));
        resultMap.put("thumbnail_width", jObject.getInt("thumbnail_width"));
        resultMap.put("thumbnail_url", jObject.getString("thumbnail_url"));

        return resultMap;
    }
}
