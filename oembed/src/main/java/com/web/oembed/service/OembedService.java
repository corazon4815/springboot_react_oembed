package com.web.oembed.service;

import com.web.oembed.JsonData;
import com.web.oembed.common.DataHandler;
import com.web.oembed.common.exception.CustomException;
import com.web.oembed.dto.OembedDto;
import com.web.oembed.provider.Provider;
import com.web.oembed.provider.ProviderUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class OembedService {

    private final ProviderUtil providerUtil;
    private final DataHandler dataHandler;

    private final JsonData jsondata;

    public OembedDto getOembed(String url) throws CustomException, IOException {
        String oembedUrl = getOembedUrl(url);
        String json = dataHandler.getData(oembedUrl);
        return jsondata.json(json);
    }

    public String getOembedUrl(String url) throws CustomException {
        String oembedUrl = null;
        try {
            if (url.contains(Provider.youtube.getValue())) oembedUrl = providerUtil.getYoutubeOembedUrl(url);
            if (url.contains(Provider.instagram.getValue())) oembedUrl = providerUtil.getInstagramOembedUrl(url);
            if (url.contains(Provider.twitter.getValue())) oembedUrl = providerUtil.getTwitterOembedUrl(url);
            if (url.contains(Provider.vimeo.getValue())) oembedUrl = providerUtil.getVimeoOembedUrl(url);
        } catch (NullPointerException | JSONException e) {
            log.info(String.valueOf(e));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return oembedUrl;
    }

}
