package com.li.house.common.util;

/**
 * @author Mr.Li
 * @createTime 2019
 */
public enum ResultCode {

    USER_BAN(-2, "您的账户已被封禁"),
    TOKEN_EXPIRE(-1, "token expire"),
    ACCESS_DENIED(-3, "access denied"),

    ERROR(1, "fail"),
    SUCCESS(0, "返回成功"),


    UNKNOW_ERROR(100000, "未知异常"),
    ILLEGAL_ARGUMENT(100001, "illegal argument"),
    METHOD_NOT_ALLOW(100002, "method not allow"),
    MESSAGE_NOT_READABLE(100003, "message not readable"),
    UNSUPPORTED_MEDIA_TYPE(100004, "unsupported media type"),
    PAGE_NOT_FOUND(100005, "page not found"),


    USER_NOT_FOUND(200001, "user not found"),
    USER_PASSWORD_NOT_MATCH(200002, "account and password mismatch "),
    ACCOUNT_EXIST(200003, "account already exist"),
    REQUIRED_OPTIONS_ARE_NOT_EMPTY(200005,"the required options are not empty"),
    VERIFICATION_CODE_ERROR(200006,"verification code error"),
    USERNAME_IS_ERROR(200007,"the username is error"),
    USER_PASSWORD_IS_ERROR(200008, "password  is error "),
    PAYMENT_IS_EMPTY(200009," payment is empty"),


    DEVICE_NOT_FOUND(300001, "device not found"),
    DEVICE_CONTROL_FAIL(300002, "control fail"),
    DEVICE_COMMAND(300003, "command error");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
