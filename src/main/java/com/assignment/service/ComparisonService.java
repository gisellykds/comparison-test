package com.assignment.service;

import com.assignment.model.enums.ComparisonResult;

public interface ComparisonService {

    public ComparisonResult compare(Double redisAmount, Double pamount);
}
