package com.example.hospitalvizsgaremek.service;

import com.example.hospitalvizsgaremek.entity.Doctor;
import com.example.hospitalvizsgaremek.entity.Patient;
import com.example.hospitalvizsgaremek.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DoctorService {

    private DoctorRepository doctorRepository;


    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow();
    }

    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }


    public void saveDoctor(Doctor doctor) {
         doctorRepository.save(doctor);
    }

    public void savePatient(Long id, Patient patient) {
       var  optionalDoctor= doctorRepository.findById(id);
       if (optionalDoctor.isPresent()) {
           Doctor doctor=optionalDoctor.get();
           doctor.getPatients().add(patient);
           doctorRepository.save(doctor);
       }
    }


//    public void(Patient patient) {
//
//        Doctor doctor = patient.getDoctor();
//        List<Patient> patients = doctor.getPatients();
//        patients.add(patient);
//        doctorRepository.save(doctor);
//        patientRepository.save(patient);
//    }


}
