package com.example.hospitalvizsgaremek.controller;


import com.example.hospitalvizsgaremek.entity.Doctor;
import com.example.hospitalvizsgaremek.entity.Patient;
import com.example.hospitalvizsgaremek.service.DoctorService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctor")
@OpenAPIDefinition(info = @Info(title = "API for Hospital"))

public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Operation(summary = "Returns all doctors.")
    @GetMapping

    public List<Doctor> getAllDoctors() { //OK
        return doctorService.getAllDoctors();
    }

    @Operation(summary = "Returns a  doctor by  id.")
    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable Long id) { //OK
        try {
            return ResponseEntity.ok().body(doctorService.getDoctorById(id)); //200
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build(); //404
        }
    }


    @Operation(summary = "Deletes a doctor by  id.")
    @DeleteMapping("/{id}")

    public ResponseEntity<?> deleteDoctorById(@PathVariable Long id) {  //OK

        try {
            doctorService.deleteDoctorById(id);
            return ResponseEntity.ok().build(); //200
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    @Operation(summary = "Creates a new doctor. ")
    @PostMapping

    public ResponseEntity<?> saveDoctor(@RequestBody @Valid Doctor doctor, BindingResult result) { //TODO validation NOT WORKING
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getFieldErrors().stream()
                            .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage))
                            .toString()
            );
        }
        return ResponseEntity.ok().body(doctorService.saveDoctor(doctor));


    }

    @Operation(summary = "Add a new patient to an already existing doctor. ")

    @PostMapping("/{id}/patient")

    public ResponseEntity<?> savePatient(@PathVariable Long id, @RequestBody @Valid Patient patient, BindingResult result) { //TODO validation NOT WORKING

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getFieldErrors().stream()
                            .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage))
                            .toString()
            );
        }
        return ResponseEntity.ok().body(doctorService.savePatient(id, patient));

    }


}
