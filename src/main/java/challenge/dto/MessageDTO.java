package challenge.dto;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MessageDTO
    implements Serializable {
    
    private final static long serialVersionUID = 1L;
    
    @NotNull(message = "sender cannot be null")
    private Long sender;
    @NotNull(message = "recipient cannot be null")
    private Long recipient;
    @NotNull(message = "content cannot be null")
    private MessageContentDTO content;
    
    private Long id;
    private OffsetDateTime timestamp;
    
    public MessageDTO() {
    }
    
    public MessageDTO(Long id, OffsetDateTime timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }
    
    public MessageDTO(Long id, Long sender, Long recipient, MessageContentDTO content, OffsetDateTime timestamp) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.timestamp = timestamp;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getSender() {
        return sender;
    }
    
    public void setSender(Long sender) {
        this.sender = sender;
    }
    
    public Long getRecipient() {
        return recipient;
    }
    
    public void setRecipient(Long recipient) {
        this.recipient = recipient;
    }
    
    public MessageContentDTO getContent() {
        return content;
    }
    
    public void setContent(MessageContentDTO content) {
        this.content = content;
    }
    
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
    
}
