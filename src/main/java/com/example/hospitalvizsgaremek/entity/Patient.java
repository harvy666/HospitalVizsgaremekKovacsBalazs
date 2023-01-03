package com.example.hospitalvizsgaremek.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id && age == patient.age && Objects.equals(name, patient.name) && Objects.equals(doctor, patient.doctor) && Objects.equals(receipt, patient.receipt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, doctor, receipt);
    }
}
