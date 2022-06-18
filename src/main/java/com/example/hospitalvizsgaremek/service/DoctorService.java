package com.example.hospitalvizsgaremek.service;

import com.example.hospitalvizsgaremek.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
}
