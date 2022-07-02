package com.example.hospitalvizsgaremek.integration;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import com.example.hospitalvizsgaremek.testmodels.Receipt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.hospitalvizsgaremek.data.TestReceipt.INSULIN;
import static com.example.hospitalvizsgaremek.data.TestReceipt.TYLENOL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")

public class ReceiptIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String entityUrl;

    @BeforeEach
    void setUp() {
        String baseUrl = "http://localhost:" + port;
        entityUrl = baseUrl + "/receipt";
    }

    @Test
    void emptyDatabase_getAll_shouldReturnEmptyList() {
        assertEquals(Collections.emptyList(), List.of(restTemplate.getForObject(entityUrl, Receipt[].class)));
    }


    @Test
    void emptyDatabase_addOne_shouldReturnAddedReceipt() {
        Receipt result = restTemplate.postForObject(entityUrl, INSULIN, Receipt.class);
        assertEquals(INSULIN.getName(), result.getName());
    }

    @Test
    void emptyDatabase_addMultiple_getAll_shouldReturnAllAddedReceipt() {
        List<Receipt> result = new ArrayList<>();
        result.add(restTemplate.postForObject(entityUrl, INSULIN, Receipt.class));
        result.add(restTemplate.postForObject(entityUrl, TYLENOL, Receipt.class));
        assertEquals(List.of(restTemplate.getForObject(entityUrl, Receipt[].class)).size(), result.size());
    }


    @Test
    void oneReceiptStored_updateIt_ReceiptShouldBeUpdated() {
        Receipt testReceipt =restTemplate.postForObject(entityUrl, INSULIN, Receipt.class);
        testReceipt.setPrice(99);
        String url = entityUrl + "/" + testReceipt.getId();
        restTemplate.put(url, testReceipt);
        Receipt result = restTemplate.getForObject(url, Receipt.class);
        assertEquals(testReceipt.getPrice(), result.getPrice());
    }

    @Test
    void oneReceiptStored_getById_shouldReturnStoredReceipt() {
        Receipt result = restTemplate.postForObject(entityUrl, INSULIN, Receipt.class);
        String url = entityUrl + "/1";
        Receipt receiptById=restTemplate.getForObject(url,Receipt.class);
        assertEquals(result.getPrice(),receiptById.getPrice());

    }

    @Test
    void oneReceiptStored_deleteById_getAllShouldReturnEmptyList() {
        Receipt testReceipt =restTemplate.postForObject(entityUrl, INSULIN, Receipt.class);
        assertNotNull(testReceipt.getId());
        restTemplate.delete(entityUrl + "/" + testReceipt.getId());
        Receipt [] result = restTemplate.getForObject(entityUrl, Receipt[].class);
        assertEquals(0, result.length);
    }


}
