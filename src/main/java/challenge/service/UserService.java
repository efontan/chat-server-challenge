package challenge.service;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

import java.util.UUID;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import challenge.dao.UserRepository;
import challenge.dto.UserRequestDTO;
import challenge.dto.UserResponseDTO;
import challenge.exception.DuplicatedEntityException;
import challenge.model.User;

@Service
public class UserService {
    
    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    
    @Autowired
    private UserRepository userRepository;
    
    @Transactional(readOnly = false, rollbackFor = Exception.class, propagation = REQUIRED)
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = this.mapToUserEntity(userRequestDTO);
        
        LOGGER.info("Creating a new user: {}", user);
        this.saveUser(user);
        
        return this.mapToUserResponseDTO(user);
    }
    
    private void saveUser(User user) {
        try {
            this.userRepository.save(user);
        } catch (ConstraintViolationException e) {
            throw new DuplicatedEntityException(e);
        }
    }
    
    private User mapToUserEntity(UserRequestDTO userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setUserId(UUID.randomUUID().toString());
        return user;
    }
    
    // TODO: use a mapper (like Orika) to map entities and DTOs 
    private UserResponseDTO mapToUserResponseDTO(User user) {
        return new UserResponseDTO(user.getUserId());
    }
}
