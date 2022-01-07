package com.example.userCenter.common.strategy;

public enum OperatorStrategyEnum {

    SUCCESS("SUCCESS", "Operation Success"),

    FAIL("FAIL", "Operation Failure"),

    UNKNOWN("UNKNOWN", "Unknown Error"),

    EMAIL_FAIL("EMAIL_FAIL", "Failed to send verification code");

    private String code;

    private String description;

    OperatorStrategyEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
