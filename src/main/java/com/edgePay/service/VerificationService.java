package com.edgePay.service;

import com.edgePay.dto.ResponseDTO;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VerificationService {


    public ResponseDTO verify(String idType, String idNumber){

        if(idType == null || idNumber == null)
            return new ResponseDTO("01", "FAILED!");

        if(idType.equalsIgnoreCase("NIN"))
            return new ResponseDTO("00", "SUCCESSFUL", verifyNIN(idNumber));

        if(idType.equalsIgnoreCase("VIN"))
            return new ResponseDTO("00", "SUCCESSFUL", verifyNIN(idNumber));

        return new ResponseDTO("01", "FAILED!");
    }

    private Map<String, Object> verifyNIN(String nin){

        Map<String, Object> response = new HashMap<>();

        Faker faker = new Faker();
        response.put("fullname", faker.name().fullName());

        return response;
    }

    private Map<String, Object> verifyVIN(String vin){

        Map<String, Object> response = new HashMap<>();

        Faker faker = new Faker();
        response.put("fullname", faker.name().fullName());

        return response;
    }
}
