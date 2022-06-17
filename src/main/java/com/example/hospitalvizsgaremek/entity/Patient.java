package com.example.hospitalvizsgaremek.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//todo validate all field+ add table/column name

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;

//    @ManyToOne
//    @JsonBackReference
    private Doctor doctor;
    private Receipt receipt;
}
