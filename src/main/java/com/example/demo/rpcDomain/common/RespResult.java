package com.example.demo.rpcDomain.common;

import java.io.Serializable;

public class RespResult<T> implements Serializable {

    int code;

    String message;

    T data;

    public RespResult(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public RespResult(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }
}
