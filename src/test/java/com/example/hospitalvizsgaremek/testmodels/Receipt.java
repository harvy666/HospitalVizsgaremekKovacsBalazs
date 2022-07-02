package com.example.hospitalvizsgaremek.testmodels;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    @Range(min=1, max=9999)
    private int price;


    public Receipt(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}