package com.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import services.OwnerService;

// Double request mapping - needed to remove
//@RequestMapping("/owners")
@Controller
public class OwnerController {

    // injecting OwnerService dependency by constructor
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/owners"})
    // bring a Spring Model - interface for passing objects to UI
    public String listOwners(Model model){
        // attributeName and value inside the model
        model.addAttribute("ownersSet", ownerService.findAll());

        return "owners/index";
    }
}
