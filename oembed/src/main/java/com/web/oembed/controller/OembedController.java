package com.web.oembed.controller;

import com.web.oembed.common.dto.ResponseDTO;
import com.web.oembed.common.exception.CustomException;
import com.web.oembed.service.OembedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/oembed")
@RequiredArgsConstructor
public class OembedController {


    private final OembedService oembedService;

    /*
     *   Oembed 호출
     */
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOembed(@RequestParam String url) throws CustomException, IOException {
        JSONArray json = oembedService.getOembed(url);
        return new ResponseEntity<>(new ResponseDTO<>(1, "조회 성공", json), HttpStatus.OK);
    }
}
