package com.example.hospitalvizsgaremek.controller;

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


    @PostMapping

    public void savePatient(@RequestBody Patient patient) {
        patientService.save(patient);
    }

//  TODO priority: hogyan updatelek egy Beteget hogy valtozzon a Doktorban is ? (most csak eltűnik simán )

    @PutMapping("/{id}")
    public void updatePatientById(@PathVariable Long id, @RequestBody Patient patient) {
        patient.setId(id);
        patientService.save(patient);

    }

}
