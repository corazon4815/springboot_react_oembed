package com.web.oembed.dto;

import lombok.experimental.SuperBuilder;

/*
 *   유튜브 dto
 */
@SuperBuilder
public class YoutubeDto extends OembedDto {
    private String title;
    private long height;
    private long width;
    private String version;
    private long thumbnailHeight;
    private long thumbnailWidth;
    private String thumbnailUrl;

}
