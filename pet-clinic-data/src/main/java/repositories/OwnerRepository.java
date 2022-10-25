package repositories;

import model.Owner;
import org.springframework.data.repository.CrudRepository;

// ID value in BaseEntity is Long
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
