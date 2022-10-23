package com.sfgpetclinic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.OwnerService;
import services.PetService;
import services.PetTypeService;
import services.VetService;
import services.map.OwnerServiceMap;
import services.map.PetServiceMap;
import services.map.PetTypeServiceMap;
import services.map.VetServiceMap;

@Configuration
public class ContextConfig {

    @Bean
    public VetService vetService() {
        return new VetServiceMap();
    }

    @Bean
    public PetTypeService petTypeService() { return new PetTypeServiceMap(); }

    @Bean
    public PetService petService() {return new PetServiceMap(); }


    @Bean
    OwnerService ownerService(PetTypeService petTypeService, PetService petService) {
        return new OwnerServiceMap(petTypeService, petService);
    }

}
