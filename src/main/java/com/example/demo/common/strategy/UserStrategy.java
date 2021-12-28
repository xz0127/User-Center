package com.example.demo.common.strategy;

import com.example.demo.rpcDomain.common.RespResult;
import com.example.demo.rpcDomain.req.RegisterRequest;

public interface UserStrategy {

    RespResult doProcess(RegisterRequest registerRequest, OperatorStrategyEnum strategyEnum);
}
