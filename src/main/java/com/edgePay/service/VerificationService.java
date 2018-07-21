package com.edgePay.service;

import com.edgePay.dto.ResponseDTO;
import com.edgePay.model.VerificationResponse;
import com.edgePay.utility.HttpRequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VerificationService {
    @Autowired
    private HttpRequestUtil requestUtil;

    public ResponseDTO verify(String idType, String idNumber){

        try {
            String baseUrl = "http://localhost:8081/user/fetch";
            VerificationResponse verificationResponse = null;
            ResponseDTO responseDTO = null;

            ObjectMapper mapper = new ObjectMapper();

            if (idType == null || idNumber == null)
                return new ResponseDTO("01", "FAILED!");

            if (idType.equalsIgnoreCase("NIN"))
                baseUrl += "/nin/" + idNumber;

            if (idType.equalsIgnoreCase("VIN"))
                baseUrl += "/vin/" + idNumber;

            HttpResponse<JsonNode> response =  HttpRequestUtil.makeGetRequest(baseUrl, null, null);
            responseDTO = mapper.readValue(response.getBody().toString(), ResponseDTO.class);

//            System.out.println(response.getBody().toString());

            return responseDTO;
//            return new ResponseDTO("00", "SUCCESSFUL", responseDTO);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseDTO("01", "FAILED!");
    }

//    private Map<String, Object> verifyNIN(String nin){
//
//        Map<String, Object> response = new HashMap<>();
//
//        Faker faker = new Faker();
//        response.put("fullname", faker.name().fullName());
//
//        return response;
//    }
//
//    private Map<String, Object> verifyVIN(String vin){
//
//        Map<String, Object> response = new HashMap<>();
//
//        Faker faker = new Faker();
//        response.put("fullname", faker.name().fullName());
//
//        return response;
//    }
}
