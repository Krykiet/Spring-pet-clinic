package com.sfgpetclinic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.*;
import services.map.*;

@Configuration
public class ContextConfig {

    @Bean
    SpecialityService specialityService() { return new SpecialityMapService(); }

    @Bean
    VisitService visitService() {
        return new VisitMapService();
    }

    @Bean
    VetService vetService(SpecialityService specialityService) {
        return new VetMapService(specialityService);
    }

    @Bean
    PetTypeService petTypeService() { return new PetTypeMapService(); }

    @Bean
    PetService petService() { return new PetMapService(); }

    @Bean
    OwnerService ownerService(PetTypeService petTypeService, PetService petService) {
        return new OwnerMapService(petTypeService, petService);
    }

}
