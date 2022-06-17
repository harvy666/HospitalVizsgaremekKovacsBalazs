package com.example.hospitalvizsgaremek.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//todo validate all field+ add table/column name

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;


//    @OneToMany(mappedBy = "zoo")
//    @JsonManagedReference
    private List<Patient> patients;
}
