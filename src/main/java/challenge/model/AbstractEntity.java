package challenge.model;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ToStringBuilder;

@MappedSuperclass
public abstract class AbstractEntity {
    
    private Long id;
    private Long version;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    public Long getId() {
        return this.id;
    }
    
    @Version
    @Column(name = "VERSION")
    public Long getVersion() {
        return this.version;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
    
}
