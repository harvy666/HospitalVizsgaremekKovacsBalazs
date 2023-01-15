package com.example.hospitalvizsgaremek.controller;

import com.example.hospitalvizsgaremek.entity.Patient;
import com.example.hospitalvizsgaremek.entity.Receipt;
import com.example.hospitalvizsgaremek.service.DoctorService;
import com.example.hospitalvizsgaremek.service.PatientService;
import com.example.hospitalvizsgaremek.service.ReceiptService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
//TODO AT THE END clear out not used methods from the old 1.0 non-Thymeleaf version
@Controller
@RequestMapping("/patient")

public class PatientController {

    private PatientService patientService;
    private DoctorService doctorService;
    private ReceiptService receiptService;

    public PatientController(PatientService patientService, DoctorService doctorService, ReceiptService receiptService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.receiptService = receiptService;
    }


    //THYMELEAF
    //TODO   save a Receipt too+updating the Patient

    @GetMapping("/add")
    public String addPatient(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("receipts",receiptService.getAllReceipts());
        model.addAttribute("patient", new Patient());
        return "addPatient";
    }

    @PostMapping("/add")
    public String addPatient(Patient patient) {
        patientService.save(patient);
        return "redirect:/patients";
    }


    //TODO DOES NOT GET CALLED WTF?
    @GetMapping("/edit/{id}")
    public String getUpdatePatient(@PathVariable Long id, Model model) {
        model.addAttribute("receipts",receiptService.getAllReceipts());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("patient", patientService.getPatientById(id)); //TODO keep this model as patient/doctor?
        return "updatePatient";
    }

    //TODO add validation to edit/update form too

    @PostMapping("/edit/{id}")

    public String getUpdatePatient( Patient patient) {
        patientService.save(patient);
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

    @GetMapping("/{id}/update")
    @Operation(summary = "Update a patient by id.")

    public String getUpdateReceiptById(@PathVariable Long id, Model model) {
        model.addAttribute(patientService.getPatientById(id));
        return "updatePatient";

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

