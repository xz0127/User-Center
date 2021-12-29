package com.example.demo.common.strategy;

import com.example.demo.common.utils.MD5Utils;
import com.example.demo.common.utils.UUIDUtils;
import com.example.demo.dao.RegisterRecordDao;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.RegisterRecord;
import com.example.demo.pojo.User;
import com.example.demo.rpcDomain.common.RespResult;
import com.example.demo.rpcDomain.common.ResultCode;
import com.example.demo.rpcDomain.req.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegisterProcessingStrategyImpl implements UserStrategy {

    @Autowired
    private RegisterRecordDao registerRecordDao;

    @Autowired
    private UserDao userDao;

    @Override
    public RespResult doProcess(RegisterRequest registerRequest, OperatorStrategyEnum strategyEnum) {
        if (strategyEnum == OperatorStrategyEnum.SUCCESS) {
            // save record
            RegisterRecord registerRecord = new RegisterRecord();
            registerRecord.setId(UUIDUtils.get());
            registerRecord.setEmail(registerRequest.getEmail());
            registerRecord.setCaptcha(registerRequest.getCaptcha());
            registerRecord.setSendTime(new Date(System.currentTimeMillis()));
            registerRecord.setUsername(registerRequest.getUsername());
            registerRecordDao.save(registerRecord);

            // save user
            User user = new User();
            user.setUsername(registerRequest.getUsername());
            user.setPassword(MD5Utils.getMD5(registerRequest.getPassword()));
            user.setId(UUIDUtils.get());
            userDao.save(user);
            return new RespResult(ResultCode.REGISTER_CAPTCHA_SENT);
        } else {
            return new RespResult(ResultCode.EMAIL_SEND_FAILURE);
        }
    }
}
