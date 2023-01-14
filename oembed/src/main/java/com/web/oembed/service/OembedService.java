package com.web.oembed.service;

import com.web.oembed.JsonData;
import com.web.oembed.common.DataHandler;
import com.web.oembed.common.exception.CustomException;
import com.web.oembed.dto.OembedDto;
import com.web.oembed.provider.Provider;
import com.web.oembed.provider.ProviderUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class OembedService {

    private final ProviderUtil providerUtil;
    private final DataHandler dataHandler;
    private final JsonData jsondata;

    public OembedDto getOembedUrl(String url) throws CustomException {
        try {
            if (url.contains(Provider.youtube.getValue())) return providerUtil.getYoutubeOembedUrl(url);
            //if (url.contains(Provider.instagram.getValue())) return providerUtil.getInstagramOembedUrl(url);
            if (url.contains(Provider.twitter.getValue())) return providerUtil.getTwitterOembedUrl(url);
            //if (url.contains(Provider.vimeo.getValue())) return providerUtil.getVimeoOembedUrl(url);
        } catch (NullPointerException | JSONException e) {
            log.info(String.valueOf(e));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
