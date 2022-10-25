package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne // many pets have same type, ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne // many pets can have same owner, ManyToOne
    @JoinColumn(name = "owner_id") // this tells Hibernate / JPA how to do mapping
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    // CascadeType.ALL - delete pet - all visits gets deleted
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>(); // pet has many visits, field initialized

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
