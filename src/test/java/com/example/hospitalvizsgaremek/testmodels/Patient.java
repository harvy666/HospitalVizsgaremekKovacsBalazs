package com.example.hospitalvizsgaremek.testmodels;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @NotBlank
    private String name;

    @Range(min = 1, max = 150)
    private int age;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonBackReference
    private Doctor doctor;


    @OneToOne
    private Receipt receipt;

    public Patient(long id, String name, int age, Doctor doctor, Receipt receipt) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.doctor = doctor;
        this.receipt = receipt;
    }
}
