package challenge.model;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_SESSIONS")
public class UserSession
    extends AbstractEntity {
    
    private String token;
    private User user;
    private OffsetDateTime creationDate;
    private OffsetDateTime finalizationDate;
    
    public UserSession() {
    }
    
    @Column(name = "TOKEN", nullable = false, updatable = false)
    public String getToken() {
        return this.token;
    }
    
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", unique = true, foreignKey = @ForeignKey(name = "FK_USER_ID"))
    public User getUser() {
        return this.user;
    }
    
    @Column(name = "CREATION_DATE")
    public OffsetDateTime getCreationDate() {
        return this.creationDate;
    }
    
    @Column(name = "FINALIZATION_DATE")
    public OffsetDateTime getFinalizationDate() {
        return finalizationDate;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public void setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }
    
    public void setFinalizationDate(OffsetDateTime finalizationDate) {
        this.finalizationDate = finalizationDate;
    }
}
    
    
