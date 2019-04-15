package com.asapp.challenge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asapp.challenge.dto.UserRequestDTO;
import com.asapp.challenge.dto.UserResponseDTO;
import com.asapp.challenge.service.UserService;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("users")
    public UserResponseDTO createUser(@Valid @RequestBody UserRequestDTO user) {

        return this.userService.createUser(user);
    }
    
}
