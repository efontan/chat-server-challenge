package challenge.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import challenge.dao.MessageRepository;
import challenge.dto.MessageDTO;
import challenge.dto.MessageListDTO;
import challenge.dto.MessageMetadataDTO;
import challenge.exception.ValidationException;
import challenge.mapper.MessageMapper;
import challenge.model.Message;
import challenge.utils.JsonParserUtils;

@Service
public class MessageService {
    
    private static Logger LOGGER = LoggerFactory.getLogger(MessageService.class);
    
    @Autowired
    private MessageRepository messageRepository;
    
    @Autowired
    private MessageMapper messageMapper;
    
    
    public MessageDTO sendMessage(MessageDTO messageDTO) {
        LOGGER.debug("Attempt to save message: {}", messageDTO);
        
        Message message = this.messageMapper.mapToMessageEntity(messageDTO);
        this.messageRepository.save(message);
        
        return new MessageDTO(message.getId(), message.getCreationDate());
    }
    
    
    
    private MessageMetadataDTO stringToMetadata(String metadata) {
        try {
            return JsonParserUtils.stringToObject(metadata, MessageMetadataDTO.class);
        } catch (Exception e) {
            throw new ValidationException("Invalid metadata", e);
        }
    }
    
    public MessageListDTO getMessages(Long recipientId, Integer startMessageId, Integer limit) {
        LOGGER.debug("Attempt to fetch messages for recipientId: {}, startMessageId: {}, limit: {}", recipientId,
            startMessageId, limit);
        
        List<Message> allMessages = this.messageRepository.findAllByRecipientId(recipientId, Long.valueOf(startMessageId), limit);
        
        List<MessageDTO> messageDTOList = allMessages
            .stream()
            .map(m -> messageMapper.mapToMessageDTO(m))
            .collect(Collectors.toList());
        
        return new MessageListDTO(messageDTOList);
    }
}
