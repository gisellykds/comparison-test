package com.assignment.repository;

import com.assignment.model.entity.TransactionEntity;

import java.util.Optional;

public interface RedisRepository {
    public Optional<TransactionEntity> findTransactionById(Integer key);
}
