package com.web.oembed.dto;

import lombok.Builder;

@Builder
public class YoutubeDto extends OembedDto {

    private String title;
    private String authorName;
    private String authorUrl;
    private String type;
    private Integer height;
    private Integer width;
    private String version;
    private String providerName;
    private String providerUrl;
    private Integer thumbnailHeight;
    private Integer thumbnailWidth;
    private String thumbnailUrl;

}
