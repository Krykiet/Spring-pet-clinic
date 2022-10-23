package com.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    // Different request options
    @RequestMapping({"","/","index","index.html"})
    // Thymeleaf needs this to look for template called index.html
    public String index() {

        return "index";
    }
    @RequestMapping({"/oups"})
    public String oupsHandler() {
        return "notimplemented";
    }
}
