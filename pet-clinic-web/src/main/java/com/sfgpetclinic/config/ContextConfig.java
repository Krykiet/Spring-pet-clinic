package com.sfgpetclinic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.*;
import services.map.*;

@Configuration
public class ContextConfig {

    @Bean
    SpecialityService specialityService() { return new SpecialityServiceMap(); }

    @Bean
    VisitService visitService() {
        return new VisitServiceMap();
    }

    @Bean
    VetService vetService(SpecialityService specialityService) {
        return new VetServiceMap(specialityService);
    }

    @Bean
    PetTypeService petTypeService() { return new PetTypeServiceMap(); }

    @Bean
    PetService petService() { return new PetServiceMap(); }

    @Bean
    OwnerService ownerService(PetTypeService petTypeService, PetService petService) {
        return new OwnerServiceMap(petTypeService, petService);
    }

}
