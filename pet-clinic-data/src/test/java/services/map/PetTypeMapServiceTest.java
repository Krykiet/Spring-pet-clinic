package services.map;

import model.Pet;
import model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetTypeMapServiceTest {

    PetTypeMapService petTypeMapService;
    @BeforeEach
    void setUp() {
        petTypeMapService = new PetTypeMapService();
        petTypeMapService.save(PetType.builder().build());
    }

    @Test
    void findAll() {
        Set<PetType> petTypes = petTypeMapService.findAll();
        assertEquals(1, petTypes.size());
    }

    @Test
    void findById() {
        PetType petType = petTypeMapService.findById(1L);
        assertEquals(1L, petType.getId());
    }

    @Test
    void save() {
        petTypeMapService.save(PetType.builder().build());
        assertEquals(2, petTypeMapService.findAll().size());
    }

    @Test
    void delete() {
        petTypeMapService.delete(petTypeMapService.findById(1L));
        assertEquals(0, petTypeMapService.findAll().size());
    }

    @Test
    void deleteById() {
        petTypeMapService.deleteById(1L);
        assertEquals(0, petTypeMapService.findAll().size());
    }
}