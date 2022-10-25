package model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass // we inherit from this, not map this to database
public class BaseEntity implements Serializable {

    //This is inherited by all classes, we do not need to set up this everywhere
    @Id // tells JPA this is the ID value
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment for MySQL
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
