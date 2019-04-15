package challenge.dto;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MessageMetadataDTO implements Serializable {
    
    private final static long serialVersionUID = 1L;
    private String height;
    private String width;
    private String source;
    
    public MessageMetadataDTO() {
    }
    
    public MessageMetadataDTO(String height, String width, String source) {
        this.height = height;
        this.width = width;
        this.source = source;
    }
    
    public String getHeight() {
        return height;
    }
    
    public void setHeight(String height) {
        this.height = height;
    }
    
    public String getWidth() {
        return width;
    }
    
    public void setWidth(String width) {
        this.width = width;
    }
    
    public String getSource() {
        return source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
    
}
