package com.web.oembed.provider;

import com.web.oembed.JsonData;
import com.web.oembed.common.DataHandler;
import com.web.oembed.dto.TwitterDto;
import com.web.oembed.dto.VimeoDto;
import com.web.oembed.dto.YoutubeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProviderUtil {
    private final DataHandler dataHandler;
    private final JsonData jsondata;

    public YoutubeDto getYoutubeOembedUrl(String url) throws IOException, JSONException {
        //log.info("OembedServiceimpl.youtubeHandler");
        String top = "https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
        String mid = url.split("watch\\?v=")[1];  //watch?v=
        String botm = "&format=json";
        String resultUrl = top + mid + botm;
        System.out.println(resultUrl);
        //String jsonData = getJsonObject(result);
        String json = dataHandler.getData(resultUrl);
        String data= jsondata.json(json);
        return jsondata.youtubeGetJsonObject(data);
//    return  jsonhandler.youtubeJson(jsonData);
    }

    public TwitterDto getTwitterOembedUrl(String url) throws IOException, JSONException {
        //log.info("OembedServiceimpl.youtubeHandler");
        //https://vimeo.com/api/oembed.json?url=https://vimeo.com/20097015

        String top = "https://publish.twitter.com/oembed?url=";
        String mid = url;  //watch?v=
        String botm = "&format=json";
        String resultUrl = top + mid + botm;
        System.out.println(resultUrl);
        //String jsonData = getJsonObject(result);
        String json = dataHandler.getData(resultUrl);
        //String data= jsondata.json(json);
        return jsondata.twitterGetJsonObject(json);
//    return  jsonhandler.youtubeJson(jsonData);
    }

/*    public VimeoDto getVimeoOembedUrl(String url) throws IOException, JSONException {
        //log.info("OembedServiceimpl.youtubeHandler");
        String top = "https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
        String mid = url.split("watch\\?v=")[1];  //watch?v=
        String botm = "&format=json";
        String resultUrl = top + mid + botm;
        System.out.println(resultUrl);
        //String jsonData = getJsonObject(result);
        String json = dataHandler.getData(resultUrl);
        String data= jsondata.json(json);
        return jsondata.youtubeGetJsonObject(data);
//    return  jsonhandler.youtubeJson(jsonData);
    }*/

    /*    public String getInstagramOembedUrl(String url) throws IOException, JSONException {
        //log.info("OembedServiceimpl.youtubeHandler");
        String top = "https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
        String mid = url.split("watch\\?v=")[1];  //watch?v=
        String botm = "&format=json";
        String resultUrl = top + mid + botm;
        System.out.println(resultUrl);
        //String jsonData = getJsonObject(result);
        return resultUrl;
//    return  jsonhandler.youtubeJson(jsonData);
    }*/

}
