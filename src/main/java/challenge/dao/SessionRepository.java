package challenge.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import challenge.model.User;
import challenge.model.UserSession;

@Repository
public interface SessionRepository
    extends CrudRepository<UserSession, Long> {
 
    UserSession findSessionByUser(User user);
}
