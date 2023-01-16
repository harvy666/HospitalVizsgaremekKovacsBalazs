package com.example.hospitalvizsgaremek.controller;

import com.example.hospitalvizsgaremek.entity.Receipt;
import com.example.hospitalvizsgaremek.service.ReceiptService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
//Changed so I can return simple String htmls, need to add request/responsebody to every other regular methods?
@Controller
@RequestMapping("/receipt")
public class ReceiptController {

    private ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    ///////////////THYMELEAF////////////////////////////////////

    @GetMapping("/add")
    public String addReceipt() {

        return "addReceipt";
    }

    @PostMapping("/add")
    public String addReceipt(@ModelAttribute("addReceipt") Receipt receipt, Model model) {
        receiptService.save(receipt);
        model.addAttribute("receipt", receipt);
        return "redirect:/receipts";
    }

    @GetMapping("/edit/{id}")
    public String getUpdateReceipt(@PathVariable Long id, Model model) {
        model.addAttribute("updateReceipt", receiptService.getReceiptById(id));
        return "updateReceipt";
    }

    //TODO add validation to edit/update form too

    @PostMapping("/edit/{id}")

    public String getUpdateReceipt(@ModelAttribute("updateReceipt") Receipt receipt, @PathVariable Long id, Model model) {

        receiptService.save(receipt);
        model.addAttribute("receipt", receipt);
        return "redirect:/receipts";

    }


    @GetMapping
    @Operation(summary = "Returns all receipts.")

    public List<Receipt> getAllReceipts() {
        return receiptService.getAllReceipts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Returns a receipt by id.")

    public ResponseEntity<?> getReceiptById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(receiptService.getReceiptById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/update")
    @Operation(summary = "Updates a receipt by id.")

    public String getUpdateReceiptById(@PathVariable Long id, Model model) {
       model.addAttribute(receiptService.getReceiptById(id));
       return "updateReceipt";

    }

    @PostMapping
    @Operation(summary = "Creates a new receipt. ")

    public ResponseEntity<?> saveReceipt(@RequestBody @Valid Receipt receipt, BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getFieldErrors().stream()
                            .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage))
                            .toString()
            );
        }
        return ResponseEntity.ok().body(receiptService.save(receipt));


    }

    @GetMapping("/delete/{id}")
    @Operation(summary = "Deletes  a receipt by id  ")


    public String deleteReceipt(@PathVariable Long id) {

            receiptService.deleteReceipt(id);
        return "redirect:/receipts";
        }



    @PutMapping("/{id}")
    @Operation(summary = "Updates  a receipt by id. ")
    public void updateReceipt(@PathVariable Long id, @RequestBody Receipt receipt) {
        receipt.setId(id);
        receiptService.save(receipt);
    }
}
