package challenge.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import challenge.model.UserSession;

@Repository
public interface SessionRepository
    extends CrudRepository<UserSession, Long> {
 
    Optional<UserSession> findSessionByToken(String token);
}
