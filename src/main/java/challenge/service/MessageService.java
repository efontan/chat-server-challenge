package challenge.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import challenge.constants.MessageType;
import challenge.constants.MessageVideoSource;
import challenge.dao.MessageRepository;
import challenge.dto.MessageDTO;
import challenge.dto.MessageMetadataDTO;
import challenge.exception.ValidationException;
import challenge.model.Message;
import challenge.model.User;
import challenge.utils.DateUtils;
import challenge.utils.JsonParser;

@Service
public class MessageService {
    
    private static Logger LOGGER = LoggerFactory.getLogger(MessageService.class);
    
    @Autowired
    private MessageRepository messageRepository;
    
    @Autowired
    private UserService userService;
    
    
    public MessageDTO sendMessage(MessageDTO messageDTO) {
        LOGGER.debug("Attempt to save message: {}", messageDTO);
        
        Message message = this.mapToMessageEntity(messageDTO);
        this.messageRepository.save(message);
        
        return new MessageDTO(message.getId(), message.getCreationDate());
    }
    
    private Message mapToMessageEntity(MessageDTO messageDTO) {
        MessageType messageType = this.getMessageTypeFromString(messageDTO.getContent().getType());
        
        User sender = this.userService.findUserById(messageDTO.getSender());
        User recipient = this.userService.findUserById(messageDTO.getRecipient());
        
        Message message = new Message();
        message.setCreationDate(DateUtils.getCurrentDateTimeInUTC());
        message.setMessageType(messageType);
        message.setSender(sender);
        message.setRecipient(recipient);
        
        switch (messageType) {
            case TEXT:
                message.setText(messageDTO.getContent().getText());
                break;
            case IMAGE:
                message.setUrl(messageDTO.getContent().getUrl());
                message.setMetadata(this.extractMetadata(messageDTO.getContent().getMetadata()));
            case VIDEO:
                this.validateVideoSource(messageDTO.getContent().getMetadata().getSource());
                message.setUrl(messageDTO.getContent().getUrl());
                message.setMetadata(this.extractMetadata(messageDTO.getContent().getMetadata()));
                break;
        }
        
        return message;
    }
    
    // TODO: separate validations into another classes
    private void validateVideoSource(String videoSourceAsString) {
        MessageVideoSource.fromString(videoSourceAsString).orElseThrow(() -> new ValidationException(
            "Invalid video source '" + videoSourceAsString + "'. Valid types: " + Arrays.toString(
                MessageVideoSource.values())));
    }
    
    private MessageType getMessageTypeFromString(String messageTypeAsString) {
        return MessageType.fromString(messageTypeAsString).orElseThrow(() -> new ValidationException(
            "Invalid message type '" + messageTypeAsString + "'. Valid types: " + Arrays.toString(MessageType.values())));
    }
    
    private String extractMetadata(MessageMetadataDTO metadata) {
        try {
            return JsonParser.objectToString(metadata);
        } catch (Exception e) {
            throw new ValidationException("Invalid metadata", e);
        }
    }
    
    private MessageMetadataDTO stringToMetadata(String metadata) {
        try {
            return JsonParser.stringToObject(metadata, MessageMetadataDTO.class);
        } catch (Exception e) {
            throw new ValidationException("Invalid metadata", e);
        }
    }
}
