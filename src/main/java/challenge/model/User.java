package challenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User
    extends AbstractEntity {
    
    private String userId;
    private String username;
    private String password;
    
    public User() {
    }
    
    @Column(name = "USERNAME", nullable = false, unique = true)
    public String getUsername() {
        return username;
    }
    
    @Column(name = "PASSWORD", nullable = false)
    public String getPassword() {
        return password;
    }
    
    @Column(name = "USER_ID", nullable = false, updatable = false)
    public String getUserId() {
        return userId;
    }
    
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
