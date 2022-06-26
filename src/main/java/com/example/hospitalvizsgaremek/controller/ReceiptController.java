package com.example.hospitalvizsgaremek.controller;

import com.example.hospitalvizsgaremek.entity.Doctor;
import com.example.hospitalvizsgaremek.entity.Receipt;
import com.example.hospitalvizsgaremek.service.ReceiptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {

    private ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping
    public List<Receipt> getAllReceipts() {
        return receiptService.getAllReceipts();
    } //OK

    @GetMapping("/{id}")
    public Receipt getReceiptById(@PathVariable Long id){
        return receiptService.getReceiptById(id);
    } //OK

    @PostMapping
    public void saveReceipt(@RequestBody Receipt receipt){ //OK
        receiptService.save(receipt);
    } //OK

    @DeleteMapping("/{id}")

    public void deleteReceipt(@PathVariable Long id) {
         receiptService.deleteReceipt(id);
    } //TODO NOT WORKING (needed?)

    @PutMapping("/{id}")

    public  void updateReceipt(@PathVariable Long id, @RequestBody Receipt receipt){ //OK
        receipt.setId(id);
        receiptService.save(receipt);
    }
}
