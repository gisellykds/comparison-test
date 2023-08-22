package com.comparison.service.impl;

import com.comparison.kafka.KafkaProducerService;
import com.comparison.model.Transaction;
import com.comparison.model.TransactionResult;
import com.comparison.model.entity.TransactionEntity;
import com.comparison.model.enums.ComparisonResult;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.comparison.templates.TransactionEntityTemplate.getTransactionEntity;
import static com.comparison.templates.TransactionTemplate.getTransaction;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class ComparisonResultServiceImplTest {

    @Autowired
    private ComparisonResultServiceImpl comparisonResultService;

    @MockBean
    private KafkaProducerService kafkaProducer;

    @Test
    public void shouldTestSendResultKeyNotFound() {
        Transaction transaction = getTransaction();
        comparisonResultService.sendResultKeyNotFound(transaction);

        ArgumentCaptor<TransactionResult> resultCaptor = ArgumentCaptor.forClass(TransactionResult.class);
        verify(kafkaProducer, times(1)).produce(resultCaptor.capture());
        assertEquals(ComparisonResult.KEY_NOT_FOUND, resultCaptor.getValue().getComparisonResult());
    }

    @Test
    public void shouldTestSendResultEqual() {
        TransactionEntity transactionRedis = getTransactionEntity();
        Transaction transaction = getTransaction();
        ComparisonResult comparisonResult = ComparisonResult.EQUAL;

        comparisonResultService.sendResult(transactionRedis, transaction, comparisonResult);

        ArgumentCaptor<TransactionResult> resultCaptor = ArgumentCaptor.forClass(TransactionResult.class);
        verify(kafkaProducer, times(1)).produce(resultCaptor.capture());
        assertEquals(ComparisonResult.EQUAL, resultCaptor.getValue().getComparisonResult());
    }

    @Test
    public void shouldTestSendResultNotEqual() {
        TransactionEntity transactionRedis = getTransactionEntity();
        Transaction transaction = getTransaction();
        ComparisonResult comparisonResult = ComparisonResult.NOT_EQUAL;

        comparisonResultService.sendResult(transactionRedis, transaction, comparisonResult);

        ArgumentCaptor<TransactionResult> resultCaptor = ArgumentCaptor.forClass(TransactionResult.class);
        verify(kafkaProducer, times(1)).produce(resultCaptor.capture());
        assertEquals(ComparisonResult.NOT_EQUAL, resultCaptor.getValue().getComparisonResult());
    }
}
