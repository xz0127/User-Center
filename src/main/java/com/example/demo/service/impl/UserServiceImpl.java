package com.example.demo.service.impl;

import com.example.demo.common.strategy.ContextMapper;
import com.example.demo.common.strategy.OperatorStrategyEnum;
import com.example.demo.component.exception.ValidateException;
import com.example.demo.component.validation.ReqValidateManager;
import com.example.demo.rpcDomain.common.RespResult;
import com.example.demo.rpcDomain.req.RegisterRequest;
import com.example.demo.service.ToolService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ReqValidateManager reqValidateManager;

    @Autowired
    private ToolService toolService;

    @Autowired
    private ContextMapper contextMapper;

    @Override
    public RespResult beforeRegister(RegisterRequest registerRequest) {
        // check parameter
        try {
            reqValidateManager.doExecute(registerRequest);
        } catch (ValidateException ex) {
            return new RespResult(ex.getResultCode());
        }

        // send email
        boolean isSend = toolService.sendRegisterMail(registerRequest);
        // strategy pattern
        OperatorStrategyEnum context = isSend ? OperatorStrategyEnum.SUCCESS : OperatorStrategyEnum.EMAIL_FAIL;
        return contextMapper.loadProcessor(context).doProcess(registerRequest, context);
    }
}
