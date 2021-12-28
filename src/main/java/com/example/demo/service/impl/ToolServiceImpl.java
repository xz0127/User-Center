package com.example.demo.service.impl;

import com.example.demo.common.utils.RandomCaptcha;
import com.example.demo.rpcDomain.req.RegisterRequest;
import com.example.demo.service.MailService;
import com.example.demo.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolServiceImpl implements ToolService {

    @Autowired
    private MailService mailService;

    @Override
    public String getCaptcha() {
        return null;
    }

    @Override
    public boolean sendRegisterMail(RegisterRequest registerRequest) {
        String captcha = RandomCaptcha.get();
        StringBuilder content = new StringBuilder();
        content.append("Hello, ")
                .append(registerRequest.getUsername())
                .append(", your verification code is: ")
                .append(captcha);
        return mailService.sendSimpleMail(registerRequest.getEmail(),
                "New User Registration", content.toString());
    }
}
