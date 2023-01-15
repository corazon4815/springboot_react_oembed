package com.web.oembed.dto;

import lombok.experimental.SuperBuilder;

/*
 *   트위터 dto
 */
@SuperBuilder
public class TwitterDto extends OembedDto {
    private String url;
    private String html;
    private long width;
    private String cacheAge;
}
