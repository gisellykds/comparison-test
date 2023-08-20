package com.assignment.service;

import com.assignment.model.Transaction;
import com.assignment.model.entity.TransactionEntity;
import com.assignment.model.enums.ComparisonResult;

public interface ComparisonResultService {

    public void sendResultKeyNotFound(Transaction transaction);

    public void sendResult(TransactionEntity transactionRedis, Transaction transaction, ComparisonResult comparisonResult);


}
