package com.edgePay.controller;

import com.edgePay.dto.AuthRequestDTO;
import com.edgePay.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/api/v1/login")
    public Object login(@RequestBody AuthRequestDTO requestDTO){

        return authService.login(requestDTO.getUsername(), requestDTO.getPassword());
    }

}
