package challenge.mapper;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import challenge.constants.MessageType;
import challenge.constants.MessageVideoSource;
import challenge.dto.MessageContentDTO;
import challenge.dto.MessageDTO;
import challenge.dto.MessageMetadataDTO;
import challenge.exception.ValidationException;
import challenge.model.Message;
import challenge.model.User;
import challenge.service.UserService;
import challenge.utils.DateUtils;
import challenge.utils.JsonParserUtils;

@Component
public class MessageMapper {
    
    @Autowired
    private UserService userService;
    
    public Message mapToMessageEntity(MessageDTO messageDTO) {
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
                break;
            case VIDEO:
                this.validateVideoSource(messageDTO.getContent().getMetadata().getSource());
                message.setUrl(messageDTO.getContent().getUrl());
                message.setMetadata(this.extractMetadata(messageDTO.getContent().getMetadata()));
                break;
        }
        
        return message;
    }
    
    private MessageType getMessageTypeFromString(String messageTypeAsString) {
        return MessageType.fromString(messageTypeAsString).orElseThrow(() -> new ValidationException(
            "Invalid message type '" + messageTypeAsString + "'. Valid types: " + Arrays.toString(MessageType.values())));
    }
    
    // TODO: extract validations into another class
    private void validateVideoSource(String videoSourceAsString) {
        MessageVideoSource.fromString(videoSourceAsString).orElseThrow(() -> new ValidationException(
            "Invalid video source '" + videoSourceAsString + "'. Valid types: " + Arrays.toString(
                MessageVideoSource.values())));
    }
    
    private String extractMetadata(MessageMetadataDTO metadata) {
        try {
            return JsonParserUtils.objectToString(metadata);
        } catch (Exception e) {
            throw new ValidationException("Invalid metadata", e);
        }
    }
    
    
    public MessageDTO mapToMessageDTO(Message message) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId());
        messageDTO.setTimestamp(message.getCreationDate());
        messageDTO.setSender(message.getSender().getId());
        messageDTO.setRecipient(message.getRecipient().getId());
    
        MessageContentDTO messageContentDTO = new MessageContentDTO();
        
    
        MessageType messageType = message.getMessageType();
        messageContentDTO.setType(messageType.getDescription());
    
        switch (messageType) {
            case TEXT:
                messageContentDTO.setText(message.getText());
                break;
            case IMAGE:
            case VIDEO:
                messageContentDTO.setUrl(message.getUrl());
                messageContentDTO.setMetadata(this.buildMetadataDTO(message.getMetadata()));
                break;
        }
        
        messageDTO.setContent(messageContentDTO);
        return messageDTO;
    }
    
    private MessageMetadataDTO buildMetadataDTO(String metadataAsString) {
        try {
            return JsonParserUtils.stringToObject(metadataAsString, MessageMetadataDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Invalid metadata", e);
        }
    }
    
}
