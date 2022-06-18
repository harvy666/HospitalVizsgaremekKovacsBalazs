package com.example.hospitalvizsgaremek.controller;

import com.example.hospitalvizsgaremek.service.PatientService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    private  PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
}
