package com.assignment.repository.impl;

import com.assignment.mapper.TransactionMapper;
import com.assignment.model.entity.TransactionEntity;
import com.assignment.repository.RedisRepository;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class RedisRepositoryImpl implements RedisRepository {

    private final StringRedisTemplate stringRedisTemplate;
    private final TransactionMapper mapper;

    public RedisRepositoryImpl(StringRedisTemplate stringRedisTemplate, TransactionMapper mapper) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.mapper = mapper;
    }

    @Override
    public Optional<TransactionEntity> findTransactionById(Integer key) {
        String transactionEntityJson = stringRedisTemplate.opsForValue().get(String.valueOf(key));
        return Optional.ofNullable(mapper.jsonToTransactionEntity(transactionEntityJson));
    }
}
