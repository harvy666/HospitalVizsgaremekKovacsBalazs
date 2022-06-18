package com.example.hospitalvizsgaremek.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//todo validate all field+ add table/column name+onetoone and many anno


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int price;
    //@OneToOne
    private Patient patient;
}
