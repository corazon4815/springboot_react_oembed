package com.web.oembed.provider;

import lombok.Getter;

/*
 *   provider url enum 클래스
 */
@Getter
public enum Provider {

    youtube("youtube.com"),
    instagram("instagram.com"),
    twitter("twitter.com"),
    vimeo("vimeo.com");
    private final String value;

    Provider(String value){ this.value = value;}

    public String getValue(){
        return value;
    }

}
