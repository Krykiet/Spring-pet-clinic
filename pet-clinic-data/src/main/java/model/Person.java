package model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass // never working with this POJO, only extending
public class Person extends BaseEntity {

    @Column(name = "first_name") // hibernate does this automatically (snake_case)
    private String firstName;

    @Column(name = "last_name") // hibernate does this automatically (snake_case)
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
