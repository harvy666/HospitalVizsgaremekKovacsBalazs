package com.example.hospitalvizsgaremek.service;


import com.example.hospitalvizsgaremek.entity.Patient;
import com.example.hospitalvizsgaremek.entity.Receipt;
import com.example.hospitalvizsgaremek.repository.PatientRepository;
import com.example.hospitalvizsgaremek.repository.ReceiptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptService {
    private ReceiptRepository receiptRepository;
    private PatientRepository patientRepository;


    public ReceiptService(ReceiptRepository receiptRepository, PatientRepository patientRepository) {
        this.receiptRepository = receiptRepository;
        this.patientRepository = patientRepository;
    }

    public List<Receipt> getAllReceipts() {
        return receiptRepository.findAll();
    }

    public Receipt getReceiptById(Long id) {
        return receiptRepository.findById(id).orElseThrow();
    }

    public void deleteReceipt(Long id) {
        List<Patient> patients = patientRepository.findAll();
        for (Patient patient : patients) {
            if (patient.getReceipt() != null && patient.getReceipt().getId() == id) {
                patient.setReceipt(null);
            }
        }
        receiptRepository.deleteById(id);
    }

    public Receipt save(Receipt receipt) {
        return receiptRepository.save(receipt);
    }
}
