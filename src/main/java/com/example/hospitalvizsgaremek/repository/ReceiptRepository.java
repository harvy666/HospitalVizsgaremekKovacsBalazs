package com.example.hospitalvizsgaremek.repository;

import com.example.hospitalvizsgaremek.entity.Patient;
import com.example.hospitalvizsgaremek.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ReceiptRepository extends JpaRepository<Receipt,Long> {
}
