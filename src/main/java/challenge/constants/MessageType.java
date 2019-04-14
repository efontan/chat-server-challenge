package challenge.constants;

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
    
    public void setDescription(String description) {
        this.description = description;
    }
    
}
