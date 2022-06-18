package com.example.hospitalvizsgaremek.controller;


import com.example.hospitalvizsgaremek.service.DoctorService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
