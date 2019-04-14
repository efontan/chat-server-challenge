package challenge.model;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import challenge.constants.MessageType;

@Entity
@Table(name = "MESSAGE")
public class Message
    extends AbstractEntity {
    
    private User sender;
    private User recipient;
    private MessageType messageType;
    private String text;
    private String url;
    private String metadata;
    private OffsetDateTime creationDate;
    
    public Message() {
    }
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SENDER_USER_ID", foreignKey = @ForeignKey(name = "FK_SENDER_USER_ID"))
    public User getSender() {
        return sender;
    }
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RECIPIENT_USER_ID", foreignKey = @ForeignKey(name = "FK_RECIPIENT_USER_ID"))
    public User getRecipient() {
        return recipient;
    }
    
    @Column(name = "MESSAGE_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    public MessageType getMessageType() {
        return messageType;
    }
    
    @Column(name = "URL", length = 2083)
    public String getUrl() {
        return url;
    }
    
    @Column(name = "TEXT", length = 4096)
    public String getText() {
        return text;
    }
    
    @Column(name = "METADATA", length = 4096)
    public String getMetadata() {
        return metadata;
    }
    
    @Column(name = "CREATION_DATE")
    public OffsetDateTime getCreationDate() {
        return creationDate;
    }
    
    public void setSender(User sender) {
        this.sender = sender;
    }
    
    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
    
    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
    
    public void setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
