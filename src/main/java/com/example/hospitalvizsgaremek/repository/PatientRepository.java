package com.example.hospitalvizsgaremek.repository;

import com.example.hospitalvizsgaremek.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient,Long> {
}
