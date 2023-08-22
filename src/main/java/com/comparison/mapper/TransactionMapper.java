package com.comparison.mapper;

import com.comparison.model.entity.TransactionEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    private ObjectMapper objectMapper;

    public TransactionMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public TransactionEntity jsonToTransactionEntity(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, TransactionEntity.class);
        } catch (Exception e) {
            return null;
        }
    }
}
