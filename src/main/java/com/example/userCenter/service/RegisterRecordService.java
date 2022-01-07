package com.example.userCenter.service;

import com.example.userCenter.pojo.RegisterRecord;
import org.springframework.stereotype.Service;

@Service
public interface RegisterRecordService extends BaseService<RegisterRecord, String> {

    String getCaptchaByUsername(String username) throws NullPointerException;
}
