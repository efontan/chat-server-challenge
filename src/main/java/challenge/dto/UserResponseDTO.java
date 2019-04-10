package challenge.dto;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserResponseDTO
    implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String id;
    
    public UserResponseDTO() {
    }
    
    public UserResponseDTO(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}
