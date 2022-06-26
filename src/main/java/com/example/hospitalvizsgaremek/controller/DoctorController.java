package com.example.hospitalvizsgaremek.controller;


import com.example.hospitalvizsgaremek.entity.Doctor;
import com.example.hospitalvizsgaremek.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAllDoctors() { //OK
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    } //OK


    @DeleteMapping("/{id}")

    public void deleteDoctorById(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
    } //OK



    @PostMapping

    public void saveDoctor(@RequestBody Doctor doctor) {
    doctorService.saveDoctor(doctor);
    } //OK adding a new doctor with a patient creates the patient to (checked by its own findAll)

//
//    @PutMapping("/{id}")
//    public void updateDoctorById(@PathVariable Long id, @RequestBody Doctor doctor) {
//        doctor.setId(id);
//        doctorService.saveDoctor(doctor);
//
//    }


}
