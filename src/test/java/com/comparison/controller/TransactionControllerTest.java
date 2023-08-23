package com.comparison.controller;

import com.comparison.model.Transaction;
import com.comparison.service.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.comparison.templates.TransactionTemplate.getTransaction;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @Test
    public void shouldTestProcessTransactionResponseOK() throws Exception {
        Transaction transaction = getTransaction();
        doNothing().when(transactionService).process(any(Transaction.class));

        ResultActions resultActions = mockMvc.perform(post("/transactions")
                .content(asJsonString(transaction))
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk());
        verify(transactionService, Mockito.times(1)).process(any(Transaction.class));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
