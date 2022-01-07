package com.example.userCenter.service.impl;

import com.example.userCenter.dao.RegisterRecordDao;
import com.example.userCenter.pojo.RegisterRecord;
import com.example.userCenter.service.RegisterRecordService;
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
