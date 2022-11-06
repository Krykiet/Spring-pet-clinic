package com.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

}
