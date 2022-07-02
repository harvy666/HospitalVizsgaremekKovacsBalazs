package com.example.hospitalvizsgaremek.repository;

import com.example.hospitalvizsgaremek.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface ReceiptRepository extends JpaRepository<Receipt,Long> {
}
