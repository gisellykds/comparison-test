package com.comparison.service.impl;

import com.comparison.model.Transaction;
import com.comparison.model.entity.TransactionEntity;
import com.comparison.model.enums.ComparisonResult;
import com.comparison.repository.RedisRepository;
import com.comparison.service.ComparisonResultService;
import com.comparison.service.ComparisonService;
import com.comparison.service.TransactionService;
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
