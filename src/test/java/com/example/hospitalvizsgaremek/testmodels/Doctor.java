package com.example.hospitalvizsgaremek.testmodels;


import com.example.hospitalvizsgaremek.entity.Patient;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Doctor {

    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Doctor name cannot be empty!")

    private String name;



    @OneToMany(mappedBy = "doctor")
    @JsonManagedReference


    private List<Patient> patients;

    public Doctor(long id, String name, List<Patient> patients) {
        this.id = id;
        this.name = name;
        this.patients = patients;
    }
}
