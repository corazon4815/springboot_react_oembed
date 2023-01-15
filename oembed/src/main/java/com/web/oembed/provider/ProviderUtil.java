package com.web.oembed.provider;

import com.web.oembed.common.HttpDataHandler;
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
    private final HttpDataHandler httpdataHandler;
    private final ProviderHandler jsondata;

    /*
     *   유튜브 Oembed 데이터를 가져오는 url을 만든다.
     */
    public YoutubeDto getYoutubeOembedUrl(String url) throws IOException, JSONException {
        String top = "https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
        String mid = url.split("watch\\?v=")[1];  //watch?v=
        String bottom = "&format=json";
        String resultUrl = top + mid + bottom;
        JSONObject json = httpdataHandler.getData(resultUrl);
        return jsondata.youtubeGetJsonObject(json);
    }

    /*
     *   트위터 Oembed 데이터를 가져오는 url을 만든다.
     */
    public TwitterDto getTwitterOembedUrl(String url) throws IOException, JSONException {
        String top = "https://publish.twitter.com/oembed?url=";
        String mid = url;
        String bottom = "&format=json";
        String resultUrl = top + mid + bottom;
        JSONObject json = httpdataHandler.getData(resultUrl);
        return jsondata.twitterGetJsonObject(json);
    }

    /*
     *   Vimeo Oembed 데이터를 가져오는 url을 만든다.
     */
    public VimeoDto getVimeoOembedUrl(String url) throws IOException, JSONException {
        String top = "https://vimeo.com/api/oembed.json?url=";
        String mid = url;
        String resultUrl = top + mid;
        JSONObject json = httpdataHandler.getData(resultUrl);
        return jsondata.vimeoGetJsonObject(json);
    }
}
