package com.example.hospitalvizsgaremek.service;


import com.example.hospitalvizsgaremek.entity.Receipt;
import com.example.hospitalvizsgaremek.repository.ReceiptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptService {
    private ReceiptRepository receiptRepository;

    public ReceiptService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    public List<Receipt> getAllReceipts() {
        return receiptRepository.findAll();
    }

    public Receipt getReceiptById(Long id) {
        return receiptRepository.findById(id).orElseThrow();
    }

    public void deleteReceipt(Long id) {
        receiptRepository.deleteById(id);
    }
}
