package com.comparison.service.impl;

import com.comparison.model.enums.ComparisonResult;
import com.comparison.service.ComparisonService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ComparisonServiceImpl implements ComparisonService {

    @Override
    public ComparisonResult compare(Double amount, Double pamount) {
        return (Objects.equals(amount, pamount)) ? ComparisonResult.EQUAL : ComparisonResult.NOT_EQUAL;
    }

}
