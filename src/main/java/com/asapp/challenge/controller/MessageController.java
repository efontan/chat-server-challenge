package com.asapp.challenge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asapp.challenge.dto.MessageDTO;
import com.asapp.challenge.dto.MessageListDTO;
import com.asapp.challenge.service.MessageService;

@RestController
@RequestMapping("messages")
public class MessageController {
    
    @Autowired
    private MessageService messageService;
    
    @PostMapping
    public MessageDTO sendMessage(@Valid @RequestBody MessageDTO messageDTO) {
        
        return this.messageService.sendMessage(messageDTO);
    }
    
    @GetMapping
    public MessageListDTO getMessages(@RequestParam("recipient") Long recipient, @RequestParam("start") Integer start, 
        @RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit) {
        
        return this.messageService.getMessages(recipient, start, limit);
    }
    
}
