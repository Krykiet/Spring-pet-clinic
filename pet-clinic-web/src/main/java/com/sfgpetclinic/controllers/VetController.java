package com.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import services.VetService;

@Controller
public class VetController {

    private final VetService vetService;

    // @Autowired - automatically by Spring
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets/index", "/vets", "/vets/index.html" })
    public String listVets(Model model){

        model.addAttribute("vetsSet", vetService.findAll());

        return "vets/index";
    }
}
