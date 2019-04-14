package challenge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.dto.MessageDTO;
import challenge.service.MessageService;

@RestController
@RequestMapping("messages")
public class MessageController {
    
    @Autowired
    private MessageService messageService;
    
    @PostMapping
    public MessageDTO sendMessage(@Valid @RequestBody MessageDTO messageDTO) {
        
        return this.messageService.sendMessage(messageDTO);
    }
    
}
