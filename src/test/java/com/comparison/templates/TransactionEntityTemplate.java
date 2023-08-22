package com.comparison.templates;

import com.comparison.model.entity.MetadataEntity;
import com.comparison.model.entity.TransactionEntity;

public class TransactionEntityTemplate {
    public static TransactionEntity getTransactionEntity() {
        TransactionEntity transaction = new TransactionEntity();
        transaction.setAmount(94.7);
        transaction.setMetadata(new MetadataEntity());
        return transaction;
    }
}
