package com.example.demo3A.controller;

import com.example.demo3A.UserDTO;
import com.example.demo3A.entity.LoginRequest;
import com.example.demo3A.entity.User;
import com.example.demo3A.repository.UserRepository;
import com.example.demo3A.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthUserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepository;

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
    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){
    	System.out.println("Received registration for a new user in the system...");
    	
    	if(userRepository.existsByUsername(userDTO.getUsername())) {
    		return ResponseEntity.badRequest().body("username exists, use another username");
    		
    	} else {
    
    	
    	userService.createUser(userDTO.getUsername(), userDTO.getPassword());
    
    	}
    	return ResponseEntity.ok("Registration successful..");
    }
    



}
