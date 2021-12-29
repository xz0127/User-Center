package com.example.demo.service;

import com.example.demo.pojo.RegisterRecord;
import org.springframework.stereotype.Service;

@Service
public interface RegisterRecordService extends BaseService<RegisterRecord, String> {

    String getCaptchaByUsername(String username) throws NullPointerException;
}
