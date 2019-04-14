package challenge.dto;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MessageListDTO
    implements Serializable {
    
    private static final long serialVersionUID = 1L;
    List<MessageDTO> messages;
    
    public MessageListDTO() {
    }
    
    public MessageListDTO(List<MessageDTO> messages) {
        this.messages = messages;
    }
    
    public List<MessageDTO> getMessages() {
        return messages;
    }
    
    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}
