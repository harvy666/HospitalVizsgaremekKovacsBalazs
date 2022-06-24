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
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    } //OK

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    } //OK

    @DeleteMapping("/{id}")

    public void deleteDoctorById(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
    }


    //todo return only a DoctorDTO w/o patients+their receipts?

    @PostMapping

    public void saveDoctor(@RequestBody Doctor doctor) {
    doctorService.saveDoctor(doctor);
    }


    @PutMapping("/{id}")
    public void updateDoctorById(@PathVariable Long id, @RequestBody Doctor doctor) {
        doctor.setId(id);
        doctorService.saveDoctor(doctor);

    }


}
