package com.comparison.kafka;

import com.comparison.model.Transaction;
import com.comparison.service.TransactionService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {

    private final TransactionService service;

    public KafkaConsumerService(@Payload TransactionService service) {
        this.service = service;
    }

    @KafkaListener(topics = "${consumer.topic.name}")
    public void consume(@Payload Transaction transaction) {
        service.process(transaction);
    }

}
