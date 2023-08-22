package com.comparison.service;

import com.comparison.model.Transaction;
import com.comparison.model.entity.TransactionEntity;
import com.comparison.model.enums.ComparisonResult;

public interface ComparisonResultService {

    public void sendResultKeyNotFound(Transaction transaction);

    public void sendResult(TransactionEntity transactionRedis, Transaction transaction, ComparisonResult comparisonResult);


}
