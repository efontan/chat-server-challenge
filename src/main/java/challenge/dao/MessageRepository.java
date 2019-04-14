package challenge.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import challenge.model.Message;

@Repository
public interface MessageRepository 
    extends CrudRepository<Message, Long> {
    
}
