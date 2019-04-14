package challenge.dto;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class MessageContentDTO
    implements Serializable {
    
    private final static long serialVersionUID = 1L;
    @NotBlank
    private String type;
    private String text;
    private String url;
    
    @JsonUnwrapped
    private MessageMetadataDTO metadata;
    
    public MessageContentDTO() {
    }
    
    public MessageContentDTO(String type, String text, String url, MessageMetadataDTO metadata) {
        this.type = type;
        this.text = text;
        this.url = url;
        this.metadata = metadata;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public MessageMetadataDTO getMetadata() {
        return metadata;
    }
    
    public void setMetadata(MessageMetadataDTO metadata) {
        this.metadata = metadata;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
    
}
