package com.example.hospitalvizsgaremek.controller;

import com.example.hospitalvizsgaremek.service.DoctorService;
import com.example.hospitalvizsgaremek.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private DoctorService doctorService;
    private PatientService patientService;

    public MainController(DoctorService doctorService, PatientService patientService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @GetMapping("/")

    public String getIndex() {
        return "index";
    }

    @GetMapping("/doctors")

    public String getDoctor(Model model) {
        model.addAttribute("doctors",doctorService.getAllDoctors() );
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
