package com.assignment.templates;

import com.assignment.model.Transaction;
import com.assignment.model.entity.MetadataEntity;
import com.assignment.model.entity.TransactionEntity;

public class TransactionEntityTemplate {
    public static TransactionEntity getTransactionEntity() {
        TransactionEntity transaction = new TransactionEntity();
        transaction.setAmount(94.7);
        transaction.setMetadata(new MetadataEntity());
        return transaction;
    }
}
