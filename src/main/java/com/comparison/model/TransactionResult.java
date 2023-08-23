package com.comparison.model;

import com.comparison.model.entity.TransactionEntity;
import com.comparison.model.enums.ComparisonResult;

import java.time.Instant;
import java.util.Objects;

public class TransactionResult {

    private Integer id;
    private Double storedAmount;
    private Double receivedAmount;
    private ComparisonResult comparisonResult;
    private Long comparisonTimestamp;

    public TransactionResult() {
    }

    public TransactionResult(Transaction transaction, TransactionEntity transactionRedis, ComparisonResult comparisonResult) {
        this.id = transaction.getPid();
        this.comparisonTimestamp = Instant.now().toEpochMilli();
        this.receivedAmount = transaction.getPamount();
        this.comparisonResult = comparisonResult;

        if (Objects.nonNull(transactionRedis)) {
            this.storedAmount = transactionRedis.getAmount();
        }
    }

    public Integer getId() {
        return id;
    }

    public Double getStoredAmount() {
        return storedAmount;
    }

    public Double getReceivedAmount() {
        return receivedAmount;
    }

    public ComparisonResult getComparisonResult() {
        return comparisonResult;
    }

    public Long getComparisonTimestamp() {
        return comparisonTimestamp;
    }
}
