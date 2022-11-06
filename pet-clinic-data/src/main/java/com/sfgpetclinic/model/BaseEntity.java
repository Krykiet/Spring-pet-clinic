package com.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass // we inherit from this, not map this to database
public class BaseEntity implements Serializable {

    //This is inherited by all classes, we do not need to set up this everywhere
    @Id // tells JPA this is the ID value
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment for MySQL
    private Long id;

}
