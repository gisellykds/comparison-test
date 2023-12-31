package com.comparison.controller;

import com.comparison.model.Transaction;
import com.comparison.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void process(@RequestBody Transaction transaction) {
        service.process(transaction);
    }

}
