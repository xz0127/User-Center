package com.example.userCenter.common.strategy;

public interface ContextMapper {

    UserStrategy loadProcessor(OperatorStrategyEnum strategyEnum);
}
