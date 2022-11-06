package com.sfgpetclinic.services.map;

import lombok.extern.slf4j.Slf4j;
import com.sfgpetclinic.model.Owner;
import com.sfgpetclinic.model.Pet;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.sfgpetclinic.services.OwnerService;
import com.sfgpetclinic.services.PetService;
import com.sfgpetclinic.services.PetTypeService;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object != null) {
            if (object.getPets() != null) {
                // if Owner has pets iterate over them
                object.getPets().forEach(pet -> {
                    // if
                    if (pet.getPetType() != null) {
                        // if we have new pet type
                        if(pet.getPetType().getId() == null) {
                            // new pet type saved in service, then we set this pet type to pet
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        log.debug("Fucked @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return null;
    }
}
