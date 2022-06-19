package com.example.hospitalvizsgaremek.entity;

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

public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    @Range(min=1, max=9999)
    private int price;


    @OneToOne
    private Patient patient;

}
