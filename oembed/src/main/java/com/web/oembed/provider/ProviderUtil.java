package com.web.oembed.provider;

import com.web.oembed.JsonData;
import com.web.oembed.common.DataHandler;
import com.web.oembed.dto.TwitterDto;
import com.web.oembed.dto.VimeoDto;
import com.web.oembed.dto.YoutubeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProviderUtil {
    private final DataHandler dataHandler;
    private final JsonData jsondata;

    public YoutubeDto getYoutubeOembedUrl(String url) throws IOException, JSONException {
        String top = "https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
        String mid = url.split("watch\\?v=")[1];  //watch?v=
        String botm = "&format=json";
        String resultUrl = top + mid + botm;
        JSONObject json = dataHandler.getData(resultUrl);
        //String data= jsondata.json(json);
        return jsondata.youtubeGetJsonObject(json);
    }

    public TwitterDto getTwitterOembedUrl(String url) throws IOException, JSONException {
        String top = "https://publish.twitter.com/oembed?url=";
        String mid = url;
        String botm = "&format=json";
        String resultUrl = top + mid + botm;
        JSONObject json = dataHandler.getData(resultUrl);
        return jsondata.twitterGetJsonObject(json);
    }

    public VimeoDto getVimeoOembedUrl(String url) throws IOException, JSONException {
        String top = "https://vimeo.com/api/oembed.json?url=";
        String mid = url;
        //String botm = "&format=json";
        String resultUrl = top + mid;
        JSONObject json = dataHandler.getData(resultUrl);
        System.out.println("json="+json);
        return jsondata.vimeoGetJsonObject(json);
    }
}
