package com.example.demo.rpcDomain.common;

public enum ResultCode {
    SUCCESS(0, "Operation Success."),

    FAIL(-1, "Operation Failed."),

    REG_DATA_IS_WRONG(-2001, "Registration data is wrong.");

    int code;

    String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
