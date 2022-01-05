package com.example.demo.rpcDomain.common;

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

    /* 业务错误：30001-39999 */
    BUSINESS_GROUP_NO_ALLOWED_DEL(30001, "Group has been used"),
    BUSINESS_THEME_NO_ALLOWED_DEL(30002, "Theme has been used"),
    BUSINESS_THEME_NO_ALLOWED_DISABLE(30003, "Theme has been used"),
    BUSINESS_THEME_DEFAULT_NO_ALLOWED_DEL(30004, "Default theme cannot be deleted"),
    BUSINESS_THEME_NO_ALLOWED_UPDATE(30005, "Theme has been used"),
    BUSINESS_IS_TOP(30040, "Top reached"),
    BUSINESS_IS_BOTTOM(30041, "Bottom reached"),
    BUSINESS_NAME_EXISTED(30051, "Name always existed"),

    /* 系统错误：40001-49999 */
    SYSTEM_INNER_ERROR(40001, "系统繁忙，请稍后重试"),
    UPLOAD_ERROR(40002, "系统异常，上传文件失败"),
    FILE_MAX_SIZE_OVERFLOW(40003, "上传尺寸过大"),
    FILE_ACCEPT_NOT_SUPPORT(40004, "上传文件格式不支持"),
    SET_UP_AT_LEAST_ONE_ADMIN(40005, "至少指定一个管理员"),
    URL_INVALID(40006, "Invalid url"),
    LINK_AND_LOGOUT_NO_MATCH(40006, "主页地址和注销地址IP不一致"),
    IP_AND_PORT_EXISTED(40007, "当前IP和端口已经被占中"),
    LINK_IS_REQUIRED(40008, "生成第三方token认证信息： 主页地址不能为空,请完善信息"),
    HTTP_MEDIA_TYPE_NOT_SUPPORT(40009, "HTTP MediaType 异常，请检查 Content-Type 是否为 application/json;charset=UTF-8 "),
    HTTP_METHOD_NOT_ALLOWED(40010, "不支持的 HTTP 请求方法，请查看文档"),
    MSG_NOT_ACCEPT(40011, "不能被处理的请求：请检查请求方法、请求头和参数详情"),

    /* 数据错误：50001-599999 */
    RESULT_DATA_NONE(50001, "Result not found"),
    REG_DATA_IS_WRONG(50002, "Error in registration data"),
    DATA_ALREADY_EXISTED(50003, "Data already exists"),

    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    INTERFACE_OUTTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),

    /* 权限错误：70001-79999 */
    PERMISSION_UNAUTHENTICATED(70001, "此操作需要登陆系统！"),
    PERMISSION_UNAUTHORISE(70002, "权限不足，无权操作！"),
    PERMISSION_EXPIRE(70003, "登录状态过期！"),
    PERMISSION_TOKEN_EXPIRED(70004, "token已过期"),
    PERMISSION_LIMIT(70005, "访问次数受限制"),
    PERMISSION_TOKEN_INVALID(70006, "无效token"),
    PERMISSION_SIGNATURE_ERROR(70007, "签名失败"),

    GENERAL_ERROR(80001, "服务器开小差了...");

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
