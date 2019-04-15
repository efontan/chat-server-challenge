package com.asapp.challenge.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asapp.challenge.dao.SessionRepository;
import com.asapp.challenge.dto.UserRequestDTO;
import com.asapp.challenge.dto.UserResponseDTO;
import com.asapp.challenge.exception.DuplicatedEntityException;
import com.asapp.challenge.model.User;
import com.asapp.challenge.model.UserSession;
import com.asapp.challenge.utils.DateUtils;
import com.asapp.challenge.utils.TokenUtils;

@Service
public class SessionService {
    
    private static Logger LOGGER = LoggerFactory.getLogger(SessionService.class);
    
    @Autowired
    private SessionRepository sessionRepository;
    
    @Autowired
    private UserService userService;
    
    public UserResponseDTO doLogin(UserRequestDTO userRequestDTO) {
        LOGGER.debug("Attempt to login for user: {}", userRequestDTO);
        User user = this.userService.retrieveAndValidateUser(userRequestDTO.getUsername(), 
            userRequestDTO.getPassword());
    
        UserSession session = new UserSession();
        session.setToken(TokenUtils.generateRandomToken());
        session.setUser(user);
        session.setCreationDate(DateUtils.getCurrentDateTimeInUTC());
        
        try {
            this.sessionRepository.save(session);
        } catch (Exception e) {
            throw new DuplicatedEntityException("User is already logged.", e);
        }
        
        return new UserResponseDTO(user.getId(), session.getToken());
    }
    
    public boolean isValidSession(String token) {
        LOGGER.debug("Attempt to validate session token: {}", token);
        return this.sessionRepository.findSessionByToken(token).isPresent();
    }
}
