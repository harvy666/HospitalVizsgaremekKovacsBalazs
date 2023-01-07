package com.example.hospitalvizsgaremek.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;


@Getter
@Setter
//@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Receipt {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @Range(min = 1, max = 9999)
    private int price;


    //populating the html only works with toString need a bidirectional onetoone for better solution?
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return id == receipt.id && price == receipt.price && Objects.equals(name, receipt.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
