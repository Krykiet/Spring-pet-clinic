package com.sfgpetclinic.services;

import com.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
    // rest of the methods are inherited from CrudService interface
    List<Owner> findAllByLastNameLike(String lastName);
}
