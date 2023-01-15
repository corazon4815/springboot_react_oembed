package com.web.oembed.common;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
@Component
public class DataHandler {

    public JSONObject getData(String url1) {
        HttpURLConnection conn = null;
        JSONObject responseJson = null;

        try {
            URL url = new URL(url1);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");

            int responseCode = conn.getResponseCode();
            if (responseCode == 401) {
                log.error("401:: Header를 확인해주세요.");
            } else if (responseCode == 500) {
                log.error("500:: 서버 에러");
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = "";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                responseJson = (JSONObject)new JSONParser().parse(sb.toString());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            log.error("not JSON Format response");
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return responseJson;
    }
}
