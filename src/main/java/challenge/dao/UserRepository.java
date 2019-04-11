package challenge.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import challenge.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
}
