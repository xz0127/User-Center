package com.example.demo.rpcDomain.common;

public enum ResultCode {
    SUCCESS(0, "Operation Success."),

    REGISTER_CAPTCHA_SENT(2001, "Verification sent"),

    FAIL(-1, "Operation Failed."),

    REG_DATA_IS_WRONG(-2001, "Registration data is wrong."),

    EMAIL_SEND_FAILURE(-2002, "Email sent failure. Please check input email."),

    WRONG_CAPTCHA(-2003, "Wrong Captcha."),

    REGISTER_RECORD_IS_EMPTY(-2004, "No register record found.");

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
