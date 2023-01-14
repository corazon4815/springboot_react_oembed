package com.web.oembed;


import com.web.oembed.dto.TwitterDto;
import com.web.oembed.dto.YoutubeDto;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JsonData {

    public JsonData() {

    }
    public String json (String data) throws JSONException {
        System.out.println("data = " + data);
        int html = data.indexOf(",\"html\"");
        int lastDot = data.lastIndexOf("\"");
        data=data.substring(0,html)+"}";
        return data;
    }

    public TwitterDto twitterGetJsonObject(String data) throws JSONException {
        System.out.println(data);
        JSONObject jObject = new JSONObject(data);
        System.out.println("jObject="+jObject);

        TwitterDto twitterDto = TwitterDto.builder()
                .url(jObject.getString("url"))
                .authorName(jObject.getString("author_name"))
                .authorUrl(jObject.getString("author_url"))
                .type(jObject.getString("type"))
                //.height(jObject.getInt("height"))
                .width(jObject.getInt("width"))
                .html(jObject.getString("html"))
                .providerName(jObject.getString("provider_name"))
                .providerUrl(jObject.getString("provider_url"))
                .cacheAge(jObject.getString("cache_age"))
                .build();
        return twitterDto;
    }

    public YoutubeDto youtubeGetJsonObject(String data) throws JSONException {
        System.out.println(data);
        JSONObject jObject = new JSONObject(data);
        System.out.println("jObject="+jObject);

        Optional<String> optional = Optional.ofNullable(jObject.getString("title"));
        String title = optional.orElse("anonymous");
        YoutubeDto youtubeDto = YoutubeDto.builder()
                .title(title)
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

        return youtubeDto;
    }
}
