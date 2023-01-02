package com.example.hospitalvizsgaremek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")

    public String getIndex() {
        return "index";
    }

    @GetMapping("/doctors")

    public String getDoctor() {
        return "doctors";
    }

    @GetMapping("/patients")

    public String getPatients() {
        return "patients";
    }

    @GetMapping("/receipts")

    public String getRecipes() {
        return "receipts";
    }

}
