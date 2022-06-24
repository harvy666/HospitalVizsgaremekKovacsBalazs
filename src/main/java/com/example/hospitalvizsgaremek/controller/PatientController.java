package com.example.hospitalvizsgaremek.controller;

import com.example.hospitalvizsgaremek.entity.Doctor;
import com.example.hospitalvizsgaremek.entity.Patient;
import com.example.hospitalvizsgaremek.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")

public class PatientController {

    private  PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping ("/{id}")

    public Patient getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }

    @DeleteMapping("/{id}")

    public void deletePatientById(@PathVariable Long id) {
        patientService.deletePatientById(id);
    }

}
