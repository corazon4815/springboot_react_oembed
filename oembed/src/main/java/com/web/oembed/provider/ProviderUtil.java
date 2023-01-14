package com.web.oembed.provider;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Slf4j
@Component
public class ProviderUtil {

    public String getYoutubeOembedUrl(String url) throws IOException, JSONException {
        //log.info("OembedServiceimpl.youtubeHandler");
        String top = "https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
        String mid = url.split("watch\\?v=")[1];  //watch?v=
        String botm = "&format=json";
        String resultUrl = top + mid + botm;
        System.out.println(resultUrl);
        //String jsonData = getJsonObject(result);
        return resultUrl;
//    return  jsonhandler.youtubeJson(jsonData);
    }

    public String getInstagramOembedUrl(String url) throws IOException, JSONException {
        //log.info("OembedServiceimpl.youtubeHandler");
        String top = "https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
        String mid = url.split("watch\\?v=")[1];  //watch?v=
        String botm = "&format=json";
        String resultUrl = top + mid + botm;
        System.out.println(resultUrl);
        //String jsonData = getJsonObject(result);
        return resultUrl;
//    return  jsonhandler.youtubeJson(jsonData);
    }

    public String getTwitterOembedUrl(String url) throws IOException, JSONException {
        //log.info("OembedServiceimpl.youtubeHandler");
        //https://vimeo.com/api/oembed.json?url=https://vimeo.com/20097015

        String top = "https://publish.twitter.com/oembed?url=";
        String mid = url;  //watch?v=
        String botm = "&format=json";
        String resultUrl = top + mid + botm;
        System.out.println(resultUrl);
        //String jsonData = getJsonObject(result);
        return resultUrl;
//    return  jsonhandler.youtubeJson(jsonData);
    }

    public String getVimeoOembedUrl(String url) throws IOException, JSONException {
        //log.info("OembedServiceimpl.youtubeHandler");
        String top = "https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
        String mid = url.split("watch\\?v=")[1];  //watch?v=
        String botm = "&format=json";
        String resultUrl = top + mid + botm;
        System.out.println(resultUrl);
        //String jsonData = getJsonObject(result);
        return resultUrl;
//    return  jsonhandler.youtubeJson(jsonData);
    }

}
