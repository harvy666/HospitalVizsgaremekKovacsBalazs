package com.example.hospitalvizsgaremek.unit;

import com.example.hospitalvizsgaremek.entity.Receipt;
import com.example.hospitalvizsgaremek.repository.ReceiptRepository;
import com.example.hospitalvizsgaremek.service.ReceiptService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReceiptUnitTests {
@InjectMocks
private ReceiptService receiptService;
@Mock
private ReceiptRepository receiptRepository;
//USELESS

//@Test
//void addReceipt_findById_should_return_Receipt() {
//    int id=1;
//    Receipt receipt = new Receipt(1,"Insulin",987);
//    when(receiptService.findById(1).thenReturn(receipt));
//
//}



}
