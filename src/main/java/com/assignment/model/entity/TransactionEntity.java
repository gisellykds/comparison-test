package com.assignment.model.entity;

public class TransactionEntity {
    private Double amount;
    private MetadataEntity metadata;

    public Double getAmount() {
        return amount;
    }

    public MetadataEntity getMetadata() {
        return metadata;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setMetadata(MetadataEntity metadata) {
        this.metadata = metadata;
    }
}
