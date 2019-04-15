package com.asapp.challenge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asapp.challenge.dto.UserRequestDTO;
import com.asapp.challenge.dto.UserResponseDTO;
import com.asapp.challenge.service.SessionService;

@RestController
public class SessionController {
    
    @Autowired
    private SessionService sessionService;
    
    @PostMapping("login")
    public UserResponseDTO login(@Valid @RequestBody UserRequestDTO user) {
        
        return this.sessionService.doLogin(user);
    }
    
}
