package com.example.hospitalvizsgaremek.controller;

import com.example.hospitalvizsgaremek.entity.Doctor;
import com.example.hospitalvizsgaremek.entity.Receipt;
import com.example.hospitalvizsgaremek.service.ReceiptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReceiptController {

    private ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping
    public List<Receipt> getAllReceipts() {
        return receiptService.getAllReceipts();
    }

    @GetMapping("/{id}")
    public Receipt getReceiptById(@PathVariable Long id){
        return receiptService.getReceiptById(id);
    }
}
