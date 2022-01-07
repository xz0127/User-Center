package com.example.userCenter.common.strategy;

import com.example.userCenter.rpcDomain.common.RespResult;
import com.example.userCenter.rpcDomain.req.RegisterRequest;

public interface UserStrategy {

    RespResult doProcess(RegisterRequest registerRequest, OperatorStrategyEnum strategyEnum);
}
