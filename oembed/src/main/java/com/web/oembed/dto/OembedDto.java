package com.web.oembed.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Builder
public class OembedDto {

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
