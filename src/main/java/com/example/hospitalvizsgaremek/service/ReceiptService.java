package com.example.hospitalvizsgaremek.service;


import com.example.hospitalvizsgaremek.repository.ReceiptRepository;
import org.springframework.stereotype.Service;

@Service
public class ReceiptService {
    private ReceiptRepository receiptRepository;

    public ReceiptService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }
}
