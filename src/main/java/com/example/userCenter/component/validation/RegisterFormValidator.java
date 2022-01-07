package com.example.userCenter.component.validation;

import com.example.userCenter.component.exception.ValidateException;
import com.example.userCenter.rpcDomain.common.ResultCode;
import com.example.userCenter.rpcDomain.req.RegisterRequest;
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
