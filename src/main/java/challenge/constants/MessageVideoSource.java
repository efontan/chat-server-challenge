package challenge.constants;

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
    
}
