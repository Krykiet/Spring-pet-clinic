package com.sfgpetclinic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.OwnerService;
import services.VetService;
import services.map.OwnerServiceMap;
import services.map.VetServiceMap;

@Configuration
public class DataLoaderConfig {

    @Bean
    OwnerService ownerService() {
        return new OwnerServiceMap();
    }

    @Bean
    VetService vetService() {
        return new VetServiceMap();
    }
}
