package com.sfgpetclinic.services.map;

import com.sfgpetclinic.services.map.PetMapService;
import com.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetMapServiceTest {

    PetMapService petMapService;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        Pet petZosia = Pet.builder().name("Zosia").build();
        petMapService.save(petZosia);
    }

    @Test
    void findAll() {
        Set<Pet> pets = petMapService.findAll();
        assertEquals(1, pets.size());
    }

    @Test
    void findById() {
        Pet pet = petMapService.findById(1L);
        assertEquals("Zosia", pet.getName());
    }

    @Test
    void save() {
        petMapService.save(Pet.builder().build());
        assertEquals(2, petMapService.findAll().size());
    }

    @Test
    void delete() {
        petMapService.delete(petMapService.findById(1L));
        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void deleteById() {
        petMapService.deleteById(1L);
        assertEquals(0, petMapService.findAll().size());
    }
}