package challenge.constants;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.lowerCase;

import java.util.Optional;

public enum MessageVideoSource {
    
    YOUTUBE("youtube"),
    VIMEO("vimeo");
    
    private String description;
    
    MessageVideoSource(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Retrieves an enum representation from a string description  
     * @param description
     * @return An Optional with the enum value if exists, otherwise an empty Optional 
     */
    public static Optional<MessageVideoSource> fromString(String description) {
        if (isNotBlank(lowerCase(description))) {
            for (MessageVideoSource messageVideoSource : values()) {
                if (messageVideoSource.getDescription().equals(description)) {
                    return Optional.of(messageVideoSource);
                }
            }
        }
        return Optional.empty();
    }
    
}
