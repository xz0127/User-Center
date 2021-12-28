package com.example.demo.common.strategy;

public interface ContextMapper {

    UserStrategy loadProcessor(OperatorStrategyEnum strategyEnum);
}
