package com.web.oembed.service;

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

    /*
     *   Oembed 데이터를 가져온다
     */
    public OembedDto getOembedUrl(String url) throws CustomException {
        try {
            if (url.contains(Provider.youtube.getValue())) return providerUtil.getYoutubeOembedUrl(url);
            if (url.contains(Provider.twitter.getValue())) return providerUtil.getTwitterOembedUrl(url);
            if (url.contains(Provider.vimeo.getValue())) return providerUtil.getVimeoOembedUrl(url);
            //if (url.contains(Provider.instagram.getValue())) return providerUtil.getInstagramOembedUrl(url);
        } catch (NullPointerException | JSONException e) {
            log.info(String.valueOf(e));
        } catch (IOException e) {
            throw new CustomException(e);
        }
        return null;
    }
}
