package com.assignment.service.impl;

import com.assignment.model.Transaction;
import com.assignment.model.entity.TransactionEntity;
import com.assignment.model.enums.ComparisonResult;
import com.assignment.repository.RedisRepository;
import com.assignment.service.ComparisonResultService;
import com.assignment.service.ComparisonService;
import com.assignment.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final RedisRepository repository;
    private final ComparisonService comparisonService;
    private final ComparisonResultService comparisonResultService;

    public TransactionServiceImpl(RedisRepository repository, ComparisonService comparisonService, ComparisonResultService comparisonResultService) {
        this.repository = repository;
        this.comparisonService = comparisonService;
        this.comparisonResultService = comparisonResultService;
    }

    public void process(Transaction transaction) {
        Optional<TransactionEntity> transactionOpt = repository.findTransactionById(transaction.getPid());

        if (transactionOpt.isEmpty()) {
            comparisonResultService.sendResultKeyNotFound(transaction);
            return;
        }

        ComparisonResult comparisonResult = comparisonService.compare(transactionOpt.get().getAmount(), transaction.getPamount());
        comparisonResultService.sendResult(transactionOpt.get(), transaction, comparisonResult);
    }
}
