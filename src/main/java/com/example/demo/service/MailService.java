package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface MailService {

    boolean sendSimpleMail(String to, String subject, String content);
}
