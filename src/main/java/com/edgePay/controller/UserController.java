package com.edgePay.controller;

import com.edgePay.model.User;
import com.edgePay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/api/v1/user", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody User create(@RequestBody User user){

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userService.addUser(user);
    }
}
