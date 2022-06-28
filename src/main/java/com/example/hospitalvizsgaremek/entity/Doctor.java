package com.example.hospitalvizsgaremek.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
//todo validate all field+ add table/column name

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Doctor {

    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Doctor name cannot be empty!")

    private String name;



    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
   @JsonManagedReference
   // @JsonBackReference //maybe good/other problem?


    private List<Patient> patients;


}
