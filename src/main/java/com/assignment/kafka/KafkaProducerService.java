package com.assignment.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String topic;

    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate,
                                @Value("${result.topic.name}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void produce(Object message) {
        kafkaTemplate.send(topic, message);
    }

}
