package com.example.hospitalvizsgaremek.controller;

import com.example.hospitalvizsgaremek.entity.Doctor;
import com.example.hospitalvizsgaremek.entity.Receipt;
import com.example.hospitalvizsgaremek.service.ReceiptService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {

    private ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping
    @Operation(summary = "Returns all receipts.")

    public List<Receipt> getAllReceipts() {
        return receiptService.getAllReceipts();
    } //OK

    @GetMapping("/{id}")
    @Operation(summary = "Returns a receipt by id.")

    public ResponseEntity<?> getReceiptById(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(receiptService.getReceiptById(id)); //200
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build(); //404
        }
    } //OK

    @PostMapping
    @Operation(summary = "Creates a new receipt. ")

    public ResponseEntity<?> saveReceipt(@RequestBody @Valid Receipt receipt, BindingResult result){ //OK

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getFieldErrors().stream()
                            .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage))
                            .toString()
            );
        }
        return ResponseEntity.ok().body(receiptService.save(receipt));


    } //OK

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes  a receipt by id and removes it from all patients. ")


    public ResponseEntity<?> deleteReceipt(@PathVariable Long id) { //OK  //TODO cant delete Receipt what is already assigned to a Patient

        try {
            receiptService.deleteReceipt(id);
            return ResponseEntity.ok().build(); //200
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage().toString());

        }
    }



    @PutMapping("/{id}")
    @Operation(summary = "Updates  a receipt by id. ")


    public  void updateReceipt(@PathVariable Long id, @RequestBody Receipt receipt){ //OK
        receipt.setId(id);
        receiptService.save(receipt);
    }
}
