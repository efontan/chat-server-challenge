package challenge.service;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import challenge.dto.UserRequestDTO;
import challenge.dto.UserResponseDTO;
import challenge.model.User;
import challenge.dao.UserDAO;

@Service
public class UserService {
    
    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    
    @Autowired
    private UserDAO userDAO;
    
    @Transactional(readOnly = false, rollbackFor = Exception.class, propagation = REQUIRED)
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = this.mapToUserEntity(userRequestDTO);
        
        LOGGER.info("Creating a new user: {}", user);
        this.saveUser(user);
        
        return this.mapToUserResponseDTO(user);
    }
    
    private void saveUser(User user) {
        this.userDAO.save(user);
    }
    
    // TODO: use a mapper (like Orika) to map entities and DTOs 
    private User mapToUserEntity(UserRequestDTO userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        return user;
    }
    
    private UserResponseDTO mapToUserResponseDTO(User user) {
        return new UserResponseDTO(String.valueOf(user.getId()));
    }
}
