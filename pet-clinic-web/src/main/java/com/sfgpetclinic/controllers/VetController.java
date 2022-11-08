package com.sfgpetclinic.controllers;

import com.sfgpetclinic.model.Vet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sfgpetclinic.services.VetService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class VetController {

    private final VetService vetService;

    // @Autowired - automatically by Spring
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets/index", "/vets", "/vets/index.html", "/vets.html" })
    public String listVets(Model model){

        model.addAttribute("vetsSet", vetService.findAll());

        return "vets/index";
    }

    @GetMapping("/api/vets")
    @ResponseBody // by default returns JSON
    public Set<Vet> getVetsJson() {
        return vetService.findAll();
    }
}
