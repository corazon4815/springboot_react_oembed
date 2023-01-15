package com.web.oembed.dto;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class VimeoDto extends OembedDto{
    private String version;
    private String title;
    private String isPlus;
    private String accountType;
    private String html;
    private long width;
    private long height;
    private long duration;
    private String description;
    private String thumbnailUrl;
    private long thumbnailWidth;
    private long thumbnailHeight;
    private String thumbnailUrlWithPlayButton;
    private String uploadDate;
    private long videoId;
}
