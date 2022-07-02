package com.example.hospitalvizsgaremek.data;

import com.example.hospitalvizsgaremek.testmodels.Doctor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.hospitalvizsgaremek.data.TestPatient.patient2;

public interface TestDoctor {

    Doctor doctor1=new Doctor(1,"Dr House",new ArrayList<>());
    Doctor doctor2=new Doctor(2,"Dr Green",List<>(Arrays.asList(patient2)));

}
