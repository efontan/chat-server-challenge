package challenge.dto;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserResponseDTO
    implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String token;
    
    public UserResponseDTO() {
    }
    
    public UserResponseDTO(Long id) {
        this.id = id;
    }
    
    public UserResponseDTO(Long id, String token) {
        this.id = id;
        this.token = token;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}
