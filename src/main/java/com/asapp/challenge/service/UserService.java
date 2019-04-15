package com.asapp.challenge.service;

import static java.lang.String.format;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asapp.challenge.dao.UserRepository;
import com.asapp.challenge.dto.UserRequestDTO;
import com.asapp.challenge.dto.UserResponseDTO;
import com.asapp.challenge.exception.DuplicatedEntityException;
import com.asapp.challenge.exception.InvalidCredentialsException;
import com.asapp.challenge.exception.UserNotFoundException;
import com.asapp.challenge.model.User;

@Service
public class UserService {
    
    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private AuthService authService;
    
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = this.mapToUserEntity(userRequestDTO);
        
        LOGGER.debug("Creating a new user: {}", user);
        
        try {
            this.userRepository.save(user);
        } catch (Exception e) {
            throw new DuplicatedEntityException("User already exists.", e);
        }
        
        return new UserResponseDTO(user.getId());
    }
    
    // TODO: use a mapper to map entities and DTOs 
    private User mapToUserEntity(UserRequestDTO userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(this.authService.encodePassword(userRequest.getPassword()));
        return user;
    }
    
    public User findUserById(Long userId) {
        Optional<User> maybeUser = this.userRepository.findUserById(userId);
        return maybeUser.orElseThrow(() -> new UserNotFoundException(format("User with id '%d' not found", userId)));
    }
    
    public User retrieveAndValidateUser(String username, String rawPassword) {
        LOGGER.debug("Retrieve user with username : {}", username);
        Optional<User> user = this.userRepository.findUserByUsername(username);
        
        String storedUserPassword = user.map(User::getPassword)
            .orElseThrow(() -> new InvalidCredentialsException(format("User with username '%s' not found", username)));
        
        if (!this.authService.passwordMatches(rawPassword, storedUserPassword)) {
            throw new InvalidCredentialsException("Invalid password.");
        }
        
        return user.get();
    }
    
}
