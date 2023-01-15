package com.web.oembed.provider;

import com.web.oembed.dto.TwitterDto;
import com.web.oembed.dto.VimeoDto;
import com.web.oembed.dto.YoutubeDto;
import lombok.NoArgsConstructor;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ProviderHandler {

    public YoutubeDto youtubeGetJsonObject(JSONObject jObject) throws JSONException {
        YoutubeDto youtubeDto = YoutubeDto.builder()
                .title((String) jObject.get("title"))
                .authorName((String) jObject.get("author_name"))
                .authorUrl((String) jObject.get("author_url"))
                .type((String) jObject.get("type"))
                .height((long) jObject.get("height"))
                .width((long) jObject.get("width"))
                .version((String) jObject.get("version"))
                .providerName((String) jObject.get("provider_name"))
                .providerUrl((String) jObject.get("provider_url"))
                .thumbnailHeight((long) jObject.get("thumbnail_height"))
                .thumbnailWidth((long) jObject.get("thumbnail_width"))
                .thumbnailUrl((String) jObject.get("thumbnail_url"))
                .build();
        return youtubeDto;
    }

    public TwitterDto twitterGetJsonObject(JSONObject jObject) throws JSONException {
        TwitterDto twitterDto = TwitterDto.builder()
                .url((String) jObject.get("url"))
                .authorName((String) jObject.get("author_name"))
                .authorUrl((String) jObject.get("author_url"))
                .type((String) jObject.get("type"))
                .width((long) jObject.get("width"))
                .html((String) jObject.get("html"))
                .providerName((String) jObject.get("provider_name"))
                .providerUrl((String) jObject.get("provider_url"))
                .cacheAge((String) jObject.get("cache_age"))
                .build();
        return twitterDto;
    }

    public VimeoDto vimeoGetJsonObject(JSONObject jObject) throws JSONException {
        VimeoDto vimeoDto = VimeoDto.builder()
                .type((String) jObject.get("type"))
                .version((String) jObject.get("version"))
                .providerName((String) jObject.get("provider_name"))
                .providerUrl((String) jObject.get("provider_url"))
                .title((String) jObject.get("title"))
                .authorName((String) jObject.get("author_name"))
                .authorUrl((String) jObject.get("author_url"))
                .isPlus((String) jObject.get("is_plus"))
                .accountType((String) jObject.get("account_type"))
                .html((String) jObject.get("html"))
                .width((long) jObject.get("width"))
                .height((long) jObject.get("height"))
                .duration((long) jObject.get("duration"))
                .description((String) jObject.get("description"))
                .thumbnailUrl((String) jObject.get("thumbnail_url"))
                .thumbnailWidth((long) jObject.get("thumbnail_width"))
                .thumbnailHeight((long) jObject.get("thumbnail_height"))
                .thumbnailUrlWithPlayButton((String) jObject.get("thumbnail_url_with_play_button"))
                .uploadDate((String) jObject.get("upload_date"))
                .videoId((long) jObject.get("video_id"))
                .build();
        return vimeoDto;
    }
}
