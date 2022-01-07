package com.example.userCenter.common.strategy;

import com.example.userCenter.common.utils.MD5Utils;
import com.example.userCenter.common.utils.UUIDUtils;
import com.example.userCenter.dao.RegisterRecordDao;
import com.example.userCenter.dao.UserDao;
import com.example.userCenter.pojo.RegisterRecord;
import com.example.userCenter.pojo.User;
import com.example.userCenter.rpcDomain.common.RespResult;
import com.example.userCenter.rpcDomain.common.ResultCode;
import com.example.userCenter.rpcDomain.req.RegisterRequest;
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
            return new RespResult(ResultCode.REGISTER_CAPTCHA_SEND);
        } else {
            return new RespResult(ResultCode.MAIL_SEND_FAIL);
        }
    }
}
