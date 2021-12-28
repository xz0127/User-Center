package com.example.demo.service;

import com.example.demo.rpcDomain.common.RespResult;
import com.example.demo.rpcDomain.req.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    RespResult beforeRegister(RegisterRequest registerRequest);
}
