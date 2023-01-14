package com.web.oembed;


import com.web.oembed.dto.OembedDto;
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
    public OembedDto json (String data) throws JSONException {
        System.out.println("data = " + data);
        int html = data.indexOf(",\"html\"");
        int lastDot = data.lastIndexOf("\"");
        data=data.substring(0,html)+"}";
        OembedDto oembedDto = youtubeGetJsonObject(data);
        return oembedDto;
    }

    private OembedDto youtubeGetJsonObject(String data) throws JSONException {
        System.out.println(data);
        JSONObject jObject = new JSONObject(data);
        System.out.println(jObject);

        OembedDto oembedDto = OembedDto.builder()
                .title(jObject.getString("title"))
                .authorName(jObject.getString("author_name"))
                .authorUrl(jObject.getString("author_url"))
                .type(jObject.getString("type"))
                .height(jObject.getInt("height"))
                .width(jObject.getInt("width"))
                .version(jObject.getString("version"))
                .providerName(jObject.getString("provider_name"))
                .providerUrl(jObject.getString("provider_url"))
                .thumbnailHeight(jObject.getInt("thumbnail_height"))
                .thumbnailWidth(jObject.getInt("thumbnail_width"))
                .thumbnailUrl(jObject.getString("thumbnail_url"))
                .build();

        /*Map<String, Object> resultMap = new HashMap();
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
*/
        return oembedDto;
    }
}
