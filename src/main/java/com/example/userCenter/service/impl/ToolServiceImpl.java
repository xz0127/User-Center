package com.example.userCenter.service.impl;

import com.example.userCenter.common.utils.RandomCaptcha;
import com.example.userCenter.rpcDomain.req.RegisterRequest;
import com.example.userCenter.service.MailService;
import com.example.userCenter.service.ToolService;
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
        registerRequest.setCaptcha(captcha);
        StringBuilder content = new StringBuilder();
        content.append("Hello, ")
                .append(registerRequest.getUsername())
                .append(", your verification code is: ")
                .append(captcha);
        return mailService.sendSimpleMail(registerRequest.getEmail(),
                "New User Registration", content.toString());
    }
}
