package services;

import java.util.Set;

// Based od Spring CRUD interface
// We can create common interface for higher-level services
// T - Type
// ID - ID
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);



}
