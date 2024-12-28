package com.knowledge.track.common.enums;

public enum ResponseEnum {
    SUCCESS(0, "成功"),
    SYSTEM_ERROR(1, "系统错误")
    ;


    private int code;

    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
