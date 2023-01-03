package com.example.hospitalvizsgaremek.controller;

import com.example.hospitalvizsgaremek.service.DoctorService;
import com.example.hospitalvizsgaremek.service.PatientService;
import com.example.hospitalvizsgaremek.service.ReceiptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final ReceiptService receiptService;

    public MainController(DoctorService doctorService, PatientService patientService, ReceiptService receiptService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.receiptService = receiptService;
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

    public String getReceipts(Model model) {
        model.addAttribute("receipts",receiptService.getAllReceipts() );

        return "receipts";
    }

}
