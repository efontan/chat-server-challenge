package com.asapp.challenge.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asapp.challenge.model.UserSession;

@Repository
public interface SessionRepository
    extends CrudRepository<UserSession, Long> {
 
    Optional<UserSession> findSessionByToken(String token);
    
    @Query(value = "SELECT 1", nativeQuery = true)
    Integer healthCheck();
}
