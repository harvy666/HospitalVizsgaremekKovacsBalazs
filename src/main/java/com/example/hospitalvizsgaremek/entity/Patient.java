package com.example.hospitalvizsgaremek.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//todo validate all field+ add table/column name+onetoone and many anno

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @NotBlank
    private String name;

    @Range(min=1, max=150)
    private int age;

    @ManyToOne
    //@JoinColumn(name = "doctor_id")
    @JsonBackReference

    @JoinColumn(name = "doctor_id")

    //@JsonManagedReference //maybe good?
    private Doctor doctor;

    @OneToOne
    private Receipt receipt;
}
