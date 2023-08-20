package com.assignment.service.impl;

import com.assignment.model.enums.ComparisonResult;
import com.assignment.service.ComparisonService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ComparisonServiceImpl implements ComparisonService {

    @Override
    public ComparisonResult compare(Double amount, Double pamount) {
        return (Objects.equals(amount, pamount)) ? ComparisonResult.EQUAL : ComparisonResult.NOT_EQUAL;
    }

}
