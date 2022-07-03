package com.example.hospitalvizsgaremek.service;

import com.example.hospitalvizsgaremek.entity.Doctor;
import com.example.hospitalvizsgaremek.entity.Patient;
import com.example.hospitalvizsgaremek.repository.DoctorRepository;
import com.example.hospitalvizsgaremek.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DoctorService {

    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;


    public DoctorService(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow();
    }

    public void deleteDoctorById(Long id) {
        List<Patient> patients = patientRepository.findAll();

        for (Patient patient : patients) {
            if (patient.getDoctor().getId() == id) {
                patient.setDoctor(null);
            }
        }
        doctorRepository.deleteById(id);
    }


    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Patient savePatient(Long id, Patient patient) {
        var optionalDoctor = doctorRepository.findById(id);
        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            doctor.getPatients().add(patient);
            patientRepository.save(patient);
            doctorRepository.save(doctor);
            return patient;
        }
        return null;
    }

}
