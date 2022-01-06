package com.example.demo.service;

import com.example.demo.pojo.User;
import com.example.demo.rpcDomain.common.RespResult;
import com.example.demo.rpcDomain.req.LoginRequest;
import com.example.demo.rpcDomain.req.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends BaseService<User, String>{

    RespResult beforeRegister(RegisterRequest registerRequest);

    boolean checkCaptcha(RegisterRequest registerRequest) throws NullPointerException;

    RespResult registerUser(RegisterRequest registerRequest);

    User getByUsername(String username);

    boolean checkVerified(User user);

    boolean checkPassword(User user, LoginRequest loginRequest);

    RespResult getAccountCenterInfo(String userId);

}
