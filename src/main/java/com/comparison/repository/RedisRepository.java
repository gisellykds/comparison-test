package com.comparison.repository;

import com.comparison.model.entity.TransactionEntity;

import java.util.Optional;

public interface RedisRepository {
    public Optional<TransactionEntity> findTransactionById(Integer key);
}
