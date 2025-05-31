package com.example.demo3.controller;

import com.example.demo3.entity.LoginRequest;
import com.example.demo3.entity.User;
import com.example.demo3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthUserController {

    @Autowired
    private UserService userService;

    @PostMapping("/Signin")
    public ResponseEntity<String> Signin(@RequestBody LoginRequest loginRequest) {
        boolean success = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (success) {

            return ResponseEntity.ok("Login successful");
        }
        else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }




}
