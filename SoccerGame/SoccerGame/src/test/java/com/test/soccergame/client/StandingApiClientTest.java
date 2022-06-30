package com.test.soccergame.client;


import com.test.soccergame.client.response.RawResponseData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static com.test.soccergame.util.TestUtil.getRawResponseData;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StandingApiClientTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ResponseEntity responseEntity;

    @InjectMocks
    private StandingApiClient standingApiClient;


    @Before
    public void setup(){
        ReflectionTestUtils.setField(standingApiClient,"standingApiClientUrl","test");
    }
    @Test
    public void testFetchDataSuccess(){
        when(restTemplate.getForEntity(anyString(), eq(RawResponseData[].class))).thenReturn(responseEntity);
        when(responseEntity.getBody()).thenReturn(getRawResponseData());
        RawResponseData[] rawResponseData = standingApiClient.loadData();
        Assert.assertNotNull(rawResponseData);
    }

    @Test(expected = Exception.class)
    public void loadDataWillThrowExceptionWhenClientThrowsException(){
        when(restTemplate.getForEntity(anyString(), eq(RawResponseData[].class))).thenThrow(new RestClientException("some exception"));
        standingApiClient.loadData();
    }
}