package com.assignment.service.impl;

import com.assignment.kafka.KafkaProducerService;
import com.assignment.model.Transaction;
import com.assignment.model.TransactionResult;
import com.assignment.model.entity.TransactionEntity;
import com.assignment.model.enums.ComparisonResult;
import com.assignment.service.ComparisonResultService;
import org.springframework.stereotype.Service;

@Service
public class ComparisonResultServiceImpl implements ComparisonResultService {

    private final KafkaProducerService kafkaProducer;

    public ComparisonResultServiceImpl(KafkaProducerService kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public void sendResultKeyNotFound(Transaction transaction) {
        sendResult(null, transaction, ComparisonResult.KEY_NOT_FOUND);
    }

    @Override
    public void sendResult(TransactionEntity transactionRedis, Transaction transaction, ComparisonResult comparisonResult) {
        TransactionResult resultMessage = new TransactionResult(transaction, transactionRedis, comparisonResult);
        kafkaProducer.produce(resultMessage);
    }

}
