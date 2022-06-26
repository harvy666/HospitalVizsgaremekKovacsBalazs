package com.example.hospitalvizsgaremek.service;


import com.example.hospitalvizsgaremek.entity.Doctor;
import com.example.hospitalvizsgaremek.entity.Patient;
import com.example.hospitalvizsgaremek.repository.DoctorRepository;
import com.example.hospitalvizsgaremek.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PatientService {

    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;

    public PatientService(PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow();
    }

    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

//    public void save(Patient patient) {
//        //var optionalDoctor=doctorRepository.findById(patient.getDoctor().getId());
//
//        Doctor doctor2=patient.getDoctor();
//        // save to doctor list TODO
//        if(optionalDoctor.isPresent()) {
//        Doctor doctor = optionalDoctor.get();
//        List<Patient> patients=doctor.getPatients();
//        patients.add(patient);
//        patientRepository.save(patient);
//        doctorRepository.save(doctor);
//        }


    public void save(Patient patient) {

        Doctor doctor = patient.getDoctor();
        List<Patient> patients = doctor.getPatients();
        patients.add(patient);
        doctorRepository.save(doctor);
        patientRepository.save(patient);
    }
}



