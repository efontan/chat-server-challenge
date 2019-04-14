package challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import challenge.dao.SessionRepository;
import challenge.dto.UserRequestDTO;
import challenge.dto.UserResponseDTO;
import challenge.exception.DuplicatedEntityException;
import challenge.model.User;
import challenge.model.UserSession;
import challenge.utils.DateUtils;
import challenge.utils.TokenUtils;

@Service
public class SessionService {
    
    @Autowired
    private SessionRepository sessionRepository;
    
    @Autowired
    private UserService userService;
    
    public UserResponseDTO doLogin(UserRequestDTO userRequestDTO) {
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
    
}