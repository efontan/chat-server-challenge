package challenge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import challenge.dto.UserRequestDTO;
import challenge.dto.UserResponseDTO;
import challenge.service.UserService;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("users")
    public UserResponseDTO createUser(@Valid @RequestBody UserRequestDTO user) {

        return this.userService.createUser(user);
    }
    
}
