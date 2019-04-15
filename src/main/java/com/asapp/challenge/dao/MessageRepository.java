package com.asapp.challenge.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asapp.challenge.model.Message;

@Repository
public interface MessageRepository
    extends JpaRepository<Message, Long> {
    
    @Query(value = "select * from message as m " 
        + "left join user as u on (m.RECIPIENT_USER_ID=u.id) " 
        + "where m.id >= :messageId and u.id = :recipientId " 
        + "order by m.id ASC " 
        + "limit :limit", nativeQuery = true)
    List<Message> findAllByRecipientId(@Param("recipientId") Long recipientId, @Param("messageId") Long messageId,
        @Param("limit") Integer limit);
    
}
