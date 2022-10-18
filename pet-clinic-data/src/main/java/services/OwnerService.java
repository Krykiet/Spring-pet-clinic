package services;

import model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
    // rest of the methods are inherited from CrudService interface
}
