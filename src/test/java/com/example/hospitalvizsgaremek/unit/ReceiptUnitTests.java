package com.example.hospitalvizsgaremek.unit;

import com.example.hospitalvizsgaremek.entity.Receipt;
import com.example.hospitalvizsgaremek.repository.ReceiptRepository;
import com.example.hospitalvizsgaremek.service.ReceiptService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)

public class ReceiptUnitTests {



@MockBean

private  ReceiptRepository receiptRepository;

@Autowired

private  ReceiptService receiptService;

    List<Receipt> receipts= List.of(new Receipt(1,"Insulin",99),new Receipt(2,"Tylenol",888));


    @Test
    void findAll_shouldReturnAllReceipts() {
        when(receiptRepository.findAll()).thenReturn(receipts);
        List<Receipt> actualReceipts = receiptService.getAllReceipts();
        assertThat(actualReceipts).hasSize(2);
    }



    @Test

    void findById_shouldReturnReceiptById() {
        Receipt receiptWithId1=receipts.get(0);
        when(receiptRepository.findById(1L)).thenReturn(Optional.ofNullable(receiptWithId1));
        Receipt actualReceipt =receiptService.getReceiptById(1L);
        assert receiptWithId1 != null;
        assertEquals(actualReceipt.getName(),(receiptWithId1.getName()));
    }





}
