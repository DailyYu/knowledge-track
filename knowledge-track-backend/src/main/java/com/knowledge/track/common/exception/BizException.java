package com.knowledge.track.common.exception;


import com.knowledge.track.common.enums.ResponseEnum;

public class BizException extends RuntimeException {

    private int code;

    private String message;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BizException(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    public BizException(int code, String message){
        this.code = code;
        this.message = message;
    }

}
