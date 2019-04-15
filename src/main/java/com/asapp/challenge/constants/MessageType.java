package com.asapp.challenge.constants;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

public enum MessageType {
    
    TEXT("text"),
    IMAGE("image"),
    VIDEO("video");
    
    private String description;
    
    MessageType(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Retrieves an enum representation from a string description  
     * @param description
     * @return An Optional with the enum value if exists, otherwise an empty Optional 
     */
    public static Optional<MessageType> fromString(String description) {
        if (StringUtils.isNotBlank(description)) {
            for (MessageType messageType : values()) {
                if (messageType.getDescription().equals(description)) {
                    return Optional.of(messageType);
                }
            }
        }
        return Optional.empty();
    }
    
    
}
