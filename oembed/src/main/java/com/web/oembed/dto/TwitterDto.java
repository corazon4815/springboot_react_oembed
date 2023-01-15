package com.web.oembed.dto;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class TwitterDto extends OembedDto {
    private String url;
    private String html;
    private long height;
    private long width;
    private String cacheAge;
}
