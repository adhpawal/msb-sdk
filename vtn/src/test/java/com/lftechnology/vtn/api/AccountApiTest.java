package com.lftechnology.vtn.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lftechnology.vtn.dto.request.AccountStatusRequest;
import com.lftechnology.vtn.dto.request.Credential;
import com.lftechnology.vtn.dto.response.AccountStatusResponse;
import com.lftechnology.vtn.exception.VtnException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class AccountApiTest {


    @Test
    public void getAccount() {
        //Given
        Credential credential = new Credential("LKNgtr4Of7VmHrr7Q8JJcgbt543sFB4","MNV73Bc6655dJ8UdkG4IKNGyk82nONK4");
        AccountStatusRequest accountStatusRequest = new AccountStatusRequest();
        accountStatusRequest.setEmail("peter@peterojo.com");
        AccountApi accountApi = new AccountApi(credential);

        //When0
        AccountStatusResponse accountStatusResponse = accountApi.getAccount(accountStatusRequest);

        //Then
        Assert.assertNotNull(accountStatusResponse);


    }

    @Test(expected = VtnException.class)
    public void testVtnExceptionOfInvalidAccesstoken() {

        //Given
        Credential credential = new Credential("invalid accessToken","MNV73Bc6655dJ8UdkG4IKNGyk82nONK4");

        //When
        AccountStatusRequest accountStatusRequest = new AccountStatusRequest();
        accountStatusRequest.setEmail("peter@peterojo.com");
        AccountApi accountApi = new AccountApi(credential);

        //Then
        AccountStatusResponse accountStatusResponse = accountApi.getAccount(accountStatusRequest);


    }

    @Test
    public void jaxbTest(){
        AccountStatusRequest accountStatusRequest = new AccountStatusRequest();
        accountStatusRequest.setEmail("peter@peterojo.com");
        accountStatusRequest.setPhone("333333333333333");

        ObjectMapper oMapper = new ObjectMapper();
//        oMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        Map<String, String> map = oMapper.convertValue(accountStatusRequest, Map.class);
        System.out.println(map);
    }



}