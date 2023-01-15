package com.web.oembed.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class OembedDto {
    private String type;
    private String providerName;
    private String providerUrl;
    private String authorName;
    private String authorUrl;
}
