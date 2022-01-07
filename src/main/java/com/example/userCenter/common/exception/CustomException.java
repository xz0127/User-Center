package com.example.userCenter.common.exception;

import com.example.userCenter.rpcDomain.common.ResultCode;

import java.text.MessageFormat;

public class CustomException extends RuntimeException {
    ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public CustomException(ResultCode resultCode, Object... args) {
        super(resultCode.getMessage());
        String message = MessageFormat.format(resultCode.getMessage(), args);
        resultCode.setMessage(message);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
