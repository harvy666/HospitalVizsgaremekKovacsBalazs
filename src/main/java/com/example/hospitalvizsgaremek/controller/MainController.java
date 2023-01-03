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
    private ReceiptController receiptController;

    public MainController(DoctorService doctorService, PatientService patientService, ReceiptController receiptController) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.receiptController = receiptController;
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

    public String getPatients(Model model) {
        model.addAttribute("patients",patientService.getAllPatients() );

        return "patients";
    }

    @GetMapping("/receipts")

    public String getRecipes() {
        return "receipts";
    }

}
