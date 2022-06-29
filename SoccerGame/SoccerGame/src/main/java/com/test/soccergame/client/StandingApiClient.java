package com.test.soccergame.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.soccergame.client.response.RawResponseData;
import com.test.soccergame.exception.StandingAPIException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class StandingApiClient {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${url}")
    private String standingApiClientUrl;

    public RawResponseData[] loadData(){
        ObjectMapper objectMapper = new ObjectMapper();
        RawResponseData[] rawResponseData;
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(standingApiClientUrl, String.class);
            rawResponseData = objectMapper.readValue(response.getBody(), RawResponseData[].class);
        } catch (Exception e) {
            log.error("Error while invoking standing APi Client",e);
            throw new StandingAPIException();
        }
        return rawResponseData;
    }
}
