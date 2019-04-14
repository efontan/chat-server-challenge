package challenge.dto;

import java.io.Serializable;

public class ApiError implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int status;
    private String error;
    
    public ApiError() {
    }
    
    public ApiError(int status, String error) {
        this.status = status;
        this.error = error;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getError() {
        return error;
    }
    
    public void setError(String error) {
        this.error = error;
    }
    
}
