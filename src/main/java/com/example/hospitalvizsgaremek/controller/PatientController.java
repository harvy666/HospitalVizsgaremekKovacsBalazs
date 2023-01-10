package com.example.hospitalvizsgaremek.controller;

import com.example.hospitalvizsgaremek.entity.Patient;
import com.example.hospitalvizsgaremek.entity.Receipt;
import com.example.hospitalvizsgaremek.service.DoctorService;
import com.example.hospitalvizsgaremek.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/patient")

public class PatientController {

    private PatientService patientService;
    private DoctorService doctorService;


    public PatientController(PatientService patientService, DoctorService doctorService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    //THYMELEAF
    //TODO dropdown WORKS, saving DOES NOT
    @GetMapping("/add")
    public String addPatient(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());

        return "addPatient";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute("addPatient") Patient patient, Model model) {
        patientService.save(patient);
        model.addAttribute("patient", patient);
        return "redirect:/patients";
    }

    /////////
    @GetMapping
    @Operation(summary = "Returns all patients.")

    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Returns a patient by id.")


    public ResponseEntity<?> getPatientById(@PathVariable Long id) {

        try {
            return ResponseEntity.ok().body(patientService.getPatientById(id)); //200
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build(); //404
        }

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes  a patient by id.")


    public ResponseEntity<?> deletePatientById(@PathVariable Long id) {

        try {
            patientService.deletePatientById(id);
            return ResponseEntity.ok().build(); //200
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }
}

