package com.example.hospitalvizsgaremek.repository;

import com.example.hospitalvizsgaremek.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
