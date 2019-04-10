package challenge.dao;

import org.springframework.stereotype.Repository;

import challenge.model.User;

@Repository
public class UserDAO {
    
    public void save(User user) {
        user.setId(123L);
    }
}
