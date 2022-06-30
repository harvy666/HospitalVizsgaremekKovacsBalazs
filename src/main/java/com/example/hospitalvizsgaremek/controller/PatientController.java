package com.example.hospitalvizsgaremek.controller;

import com.example.hospitalvizsgaremek.entity.Patient;
import com.example.hospitalvizsgaremek.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/patient")

public class PatientController {

    private PatientService patientService;


    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "Returns all patients.")

    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    } //OK

    @GetMapping("/{id}")
    @Operation(summary = "Returns a patient by id.")


    public ResponseEntity<?> getPatientById(@PathVariable Long id) {

        try {
            return ResponseEntity.ok().body(patientService.getPatientById(id)); //200
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build(); //404
        }

    } //OK

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes  a patient by id.")


    public ResponseEntity<?> deletePatientById(@PathVariable Long id) {

        try {
            patientService.deletePatientById(id);
            return ResponseEntity.ok().build(); //200
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        } //OK


//    @PostMapping
//
//    public void savePatient(@RequestBody Patient patient) {
//        patientService.save(patient);
//    } //TODO how to save a Patient to a specific Doctor?  In the Doctor repo?


//    //meg kell adni az id-t a Jsonban akkor felulirja a Beteget, de az Orvosbol tovabbra is eltunik
//    @PutMapping("/{id}")
//    public void updatePatientById(@PathVariable Long id, @RequestBody Patient patient) {
//        patient.setId(id);
//        patientService.save(patient);
//
//    }

    }
}

