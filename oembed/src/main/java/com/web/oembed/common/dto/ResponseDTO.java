package com.web.oembed.common.dto;

import com.web.oembed.dto.OembedDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO<T> {

    private int Code; //1(성공), -1(실패)

    private String message;

    private OembedDto data;

}
