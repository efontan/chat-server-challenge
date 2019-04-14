package challenge.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import challenge.model.User;

@Repository
public interface UserRepository 
    extends CrudRepository<User, Long> {
    
    Optional<User> findUserByUsername(String username);
    
    Optional<User> findUserById(Long id);
}
