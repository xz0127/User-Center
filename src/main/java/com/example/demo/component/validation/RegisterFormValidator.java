package com.example.demo.component.validation;

import com.example.demo.component.exception.ValidateException;
import com.example.demo.rpcDomain.common.ResultCode;
import com.example.demo.rpcDomain.req.RegisterRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service("RegisterFormValidator")
public class RegisterFormValidator implements FormValidator<RegisterRequest> {

    @Override
    public boolean canAccept(RegisterRequest arg) {
        if (arg instanceof RegisterRequest) {
            return true;
        }
        return false;
    }

    @Override
    public void validate(RegisterRequest arg) throws ValidateException {
        if (StringUtils.isBlank(arg.getUsername())
                || StringUtils.isBlank(arg.getPassword())
                || StringUtils.isBlank(arg.getEmail())
                || StringUtils.isNotBlank(arg.getCaptcha())) {
            throw new ValidateException(ResultCode.REG_DATA_IS_WRONG, "Form data wrong");
        }
    }
}
