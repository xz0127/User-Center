package com.example.demo.component.exception;

import com.example.demo.rpcDomain.common.ResultCode;

public class ValidateException extends RuntimeException {

    private ResultCode resultCode;
    private String message;

    public ValidateException(ResultCode resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
