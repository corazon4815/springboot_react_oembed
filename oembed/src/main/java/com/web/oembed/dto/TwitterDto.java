package com.web.oembed.dto;

import lombok.Builder;

@Builder
public class TwitterDto extends OembedDto {
    private String url;
    private String authorName;
    private String authorUrl;
    private String html;
    private Integer height;
    private Integer width;
    private String type;
    private String cacheAge;
    private String providerName;
    private String providerUrl;
}
