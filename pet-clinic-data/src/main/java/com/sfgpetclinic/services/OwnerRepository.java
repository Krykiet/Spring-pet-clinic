package com.sfgpetclinic.services;

import com.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// ID value in BaseEntity is Long
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    // This is wired by Spring Data JPA dynamic query methods
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
