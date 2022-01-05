package com.example.demo.rpcDomain.common;

public enum ResultCode {
    SUCCESS(0, "Operation Success."),

    REGISTER_CAPTCHA_SENT(2001, "Verification sent"),

    FAIL(-1, "Operation Failed."),

    REG_DATA_IS_WRONG(-2001, "Registration data is wrong."),

    EMAIL_SEND_FAILURE(-2002, "Email sent failure. Please check input email."),

    WRONG_CAPTCHA(-2003, "Wrong Captcha."),

    REGISTER_RECORD_IS_EMPTY(-2004, "No register record found."),

    PERMISSION_SIGNATURE_ERROR(-2005, "Signature failure"),

    PERMISSION_TOKEN_EXPIRED(-2006, "Token has expired"),

    PERMISSION_TOKEN_INVALID(-2007, "Token is invalid"),

    USER_INVALID(-2008, "User doesn't exist or is inactivated"),

    USER_LOGIN_ERROR(-2009, "Wrong password"),

    LOGIN_SUCCESS(2002, "Operation success"),

    USER_UNLOGIN_IN(-2010, "User not logged in"),

    GENERAL_ERROR(-2011, "Error");

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
