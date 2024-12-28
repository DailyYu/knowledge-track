package com.knowledge.track.common.response;


import com.knowledge.track.common.enums.ResponseEnum;

public class ResultResponse {

    /**
     * 响应码
     */
    private int code;

    /**
     * 响应的详细消息
     */
    private String message;

    /**
     * 结果
     */
    private Object data;


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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public static ResultResponse success(Object data) {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setCode(ResponseEnum.SUCCESS.getCode());
        resultResponse.setMessage(ResponseEnum.SUCCESS.getMessage());
        resultResponse.setData(data);
        return resultResponse;
    }

    public static ResultResponse error() {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setCode(ResponseEnum.SYSTEM_ERROR.getCode());
        resultResponse.setMessage(ResponseEnum.SYSTEM_ERROR.getMessage());
        return resultResponse;
    }


    public static ResultResponse buildFailure(int code, String message) {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setCode(code);
        resultResponse.setMessage(message);
        return resultResponse;
    }


}
