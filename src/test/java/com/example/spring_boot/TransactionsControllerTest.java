package com.example.spring_boot;

import com.example.spring_boot.transactions.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionsControllerTest {
    @Autowired
    private MockMvc mvc;

    private final Transaction newTransaction = new Transaction("Swiggy", 1234.0);

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void createNewTransaction() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(newTransaction))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.service").value(newTransaction.getService()))
                .andExpect(jsonPath("$.amount").value(newTransaction.getAmount()));
    }

    @Test
    public void getAllTransactions() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/transactions").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].service").value(newTransaction.getService()))
                .andExpect(jsonPath("$.[0].amount").value(newTransaction.getAmount()));
    }
}
