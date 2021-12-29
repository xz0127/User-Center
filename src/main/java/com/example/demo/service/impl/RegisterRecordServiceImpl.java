package com.example.demo.service.impl;

import com.example.demo.dao.RegisterRecordDao;
import com.example.demo.pojo.RegisterRecord;
import com.example.demo.service.BaseService;
import com.example.demo.service.RegisterRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterRecordServiceImpl extends BaseServiceImpl<RegisterRecord, String>
        implements RegisterRecordService {

    @Autowired
    private RegisterRecordDao registerRecordDao;

    @Override
    public String getCaptchaByUsername(String username) throws NullPointerException {
        RegisterRecord registerRecord = registerRecordDao.findByUsername(username);
        return registerRecord.getCaptcha();
    }

    @Override
    protected JpaRepository getRepository() {
        return registerRecordDao;
    }
}
