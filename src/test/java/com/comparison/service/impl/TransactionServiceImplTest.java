package com.comparison.service.impl;

import com.comparison.model.Transaction;
import com.comparison.model.entity.TransactionEntity;
import com.comparison.model.enums.ComparisonResult;
import com.comparison.repository.RedisRepository;
import com.comparison.service.ComparisonResultService;
import com.comparison.service.ComparisonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;
import static com.comparison.templates.TransactionEntityTemplate.getTransactionEntity;
import static com.comparison.templates.TransactionTemplate.getTransaction;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TransactionServiceImplTest {

    @Autowired
    private TransactionServiceImpl transactionService;

    @MockBean
    private RedisRepository repository;

    @MockBean
    private ComparisonService comparisonService;

    @MockBean
    private ComparisonResultService comparisonResultService;


    @Test
    public void shouldTestProcessAndSendResultWhenKeyFoundInRepository() {
        when(repository.findTransactionById(anyInt())).thenReturn(Optional.of(getTransactionEntity()));
        when(comparisonService.compare(anyDouble(), anyDouble())).thenReturn(ComparisonResult.EQUAL);

        transactionService.process(getTransaction());

        verify(comparisonResultService, times(1))
                .sendResult(any(TransactionEntity.class), any(Transaction.class), any(ComparisonResult.class));
        verifyNoMoreInteractions(comparisonResultService);
    }

    @Test
    public void shouldTestProcessAndNotSendResultWhenKeyNotFoundInRepository() {
        when(repository.findTransactionById(anyInt())).thenReturn(Optional.empty());

        transactionService.process(getTransaction());

        verify(comparisonResultService, times(1))
                .sendResultKeyNotFound(any(Transaction.class));
        verifyNoMoreInteractions(comparisonResultService);
    }
}
