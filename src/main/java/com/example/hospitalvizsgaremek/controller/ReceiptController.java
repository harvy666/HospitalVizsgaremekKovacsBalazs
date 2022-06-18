package com.example.hospitalvizsgaremek.controller;

import com.example.hospitalvizsgaremek.service.ReceiptService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiptController {

    private ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }
}
