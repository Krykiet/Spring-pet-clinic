package com.sfgpetclinic.services.map;

import com.sfgpetclinic.services.map.SpecialityMapService;
import com.sfgpetclinic.model.Speciality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SpecialityMapServiceTest {

    SpecialityMapService specialityMapService;

    @BeforeEach
    void setUp() {
        specialityMapService = new SpecialityMapService();
        specialityMapService.save(Speciality.builder().build());
    }

    @Test
    void findAll() {
        Set<Speciality> specialities = specialityMapService.findAll();
        assertEquals(1, specialities.size());
    }

    @Test
    void findById() {
        Speciality speciality = specialityMapService.findById(1L);
        assertEquals(1L, speciality.getId());
    }

    @Test
    void save() {
        specialityMapService.save(Speciality.builder().build());
        assertEquals(2, specialityMapService.findAll().size());
    }

    @Test
    void delete() {
        specialityMapService.delete(specialityMapService.findById(1L));
        assertEquals(0, specialityMapService.findAll().size());
    }

    @Test
    void deleteById() {
        specialityMapService.deleteById(1L);
        assertEquals(0, specialityMapService.findAll().size());
    }
}