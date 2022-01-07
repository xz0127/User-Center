package com.example.userCenter.service;

import com.example.userCenter.rpcDomain.req.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface ToolService {

    String getCaptcha();

    boolean sendRegisterMail(RegisterRequest registerRequest);
}
