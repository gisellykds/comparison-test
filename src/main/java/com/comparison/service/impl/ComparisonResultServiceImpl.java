package com.comparison.service.impl;

import com.comparison.kafka.KafkaProducerService;
import com.comparison.model.Transaction;
import com.comparison.model.TransactionResult;
import com.comparison.model.entity.TransactionEntity;
import com.comparison.model.enums.ComparisonResult;
import com.comparison.service.ComparisonResultService;
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
