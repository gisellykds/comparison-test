package com.comparison.service;

import com.comparison.model.enums.ComparisonResult;

public interface ComparisonService {

    public ComparisonResult compare(Double amount, Double pamount);
}
