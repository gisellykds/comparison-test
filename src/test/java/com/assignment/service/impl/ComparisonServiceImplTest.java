package com.assignment.service.impl;

import com.assignment.model.enums.ComparisonResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ComparisonServiceImplTest {

    @Autowired
    private ComparisonServiceImpl comparisonResultService;

    @Test
    public void shouldTestEqualComparison() {
        ComparisonResult comparisonResult = comparisonResultService.compare(1.0, 1.0);

        assertEquals(ComparisonResult.EQUAL, comparisonResult);
    }

    @Test
    public void shouldTestNotEqualComparison() {
        ComparisonResult comparisonResult = comparisonResultService.compare(1.0, 2.0);

        assertEquals(ComparisonResult.NOT_EQUAL, comparisonResult);
    }

    @Test
    public void shouldTestNotEqualComparisonWhenStoredAmountIsNull() {
        ComparisonResult comparisonResult = comparisonResultService.compare(null, 1.0);

        assertEquals(ComparisonResult.NOT_EQUAL, comparisonResult);
    }

    @Test
    public void shouldTestNotEqualComparisonWhenStoredPAmountIsNull() {
        ComparisonResult comparisonResult = comparisonResultService.compare(1.0, null);

        assertEquals(ComparisonResult.NOT_EQUAL, comparisonResult);
    }
}
