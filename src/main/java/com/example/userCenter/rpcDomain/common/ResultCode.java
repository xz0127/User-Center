package com.example.userCenter.rpcDomain.common;

public enum ResultCode {

    /* Success status code */
    SUCCESS(0, "Success"),

    /* Failure status code */
    FAIL(-1, "Failure"),

    /* Parameter error：10001-19999 */
    PARAM_IS_INVALID(10001, "Parameter is invalid"),
    PARAM_IS_BLANK(10002, "Parameter is blank"),
    REQ_PARAM_IS_BLANK(10006, "Request parameter is blank"),
    PARAM_TYPE_BIND_ERROR(10003, "Request format bind error"),
    PARAM_NOT_COMPLETE(10004, "Parameter is incomplete"),
    JSON_FORMAT_ERROR(10005, "Please check JSON format"),


    /* User error：20001-29999*/
    USER_NOT_LOGGED_IN(20001, "User not logged in"),
    USER_LOGIN_ERROR(20002, "Username or password wrong"),
    USER_ACCOUNT_FORBIDDEN(20003, "Account is blocked"),
    USER_NOT_EXIST(20004, "User not exist"),
    USER_CAN_USED(20005, "Account is registered"),
    USER_INVALID(20005, "Account is not registered or activated"),
    REGISTER_RECORD_IS_EMPTY(20006, "Trying to obtain register record. Incomplete"),

    GET_CAPTCHA_SUCCESS(20018, "Get captcha successfully"),
    REGISTER_CAPTCHA_SEND(20020, "Verification sent"),
    USERNAME_HAS_USED(20021, "Username has been registered"),
    MAIL_HAS_USED(20022, "Email has been used"),
    REGISTERED_SUCCESS(20023, "Registration success"),
    WRONG_CAPTCHA(20024, "Wrong captcha"),
    MAIL_SEND_FAIL(20025, "Error obtaining captcha. Email used or invalid"),
    LOGIN_SUCCESS(20026, "Login success！"),

    /* Business error：30001-39999 */
    BUSINESS_GROUP_NO_ALLOWED_DEL(30001, "Group has been used"),
    BUSINESS_THEME_NO_ALLOWED_DEL(30002, "Theme has been used"),
    BUSINESS_THEME_NO_ALLOWED_DISABLE(30003, "Theme has been used"),
    BUSINESS_THEME_DEFAULT_NO_ALLOWED_DEL(30004, "Default theme cannot be deleted"),
    BUSINESS_THEME_NO_ALLOWED_UPDATE(30005, "Theme has been used"),
    BUSINESS_IS_TOP(30040, "Top reached"),
    BUSINESS_IS_BOTTOM(30041, "Bottom reached"),
    BUSINESS_NAME_EXISTED(30051, "Name always existed"),

    /* System error：40001-49999 */
    HTTP_MEDIA_TYPE_NOT_SUPPORT(40009, "HTTP MediaType exception. Pleas check whether Content-Type is application/json;charset=UTF-8 "),
    HTTP_METHOD_NOT_ALLOWED(40010, "Http method not allowed"),
    MSG_NOT_ACCEPT(40011, "The request cannot be handled"),

    /* Data error：50001-599999 */
    RESULT_DATA_NONE(50001, "Result not found"),
    REG_DATA_IS_WRONG(50002, "Error in registration data"),

    /* Interface error：60001-69999 */
    INTERFACE_ADDRESS_INVALID(60004, "Interface address is invalid"),

    /* Permission error：70001-79999 */
    PERMISSION_TOKEN_EXPIRED(70004, "Token has expired"),
    PERMISSION_TOKEN_INVALID(70006, "Token is invalid"),
    PERMISSION_SIGNATURE_ERROR(70007, "Signature error"),

    GENERAL_ERROR(80001, "Server is down...");

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
