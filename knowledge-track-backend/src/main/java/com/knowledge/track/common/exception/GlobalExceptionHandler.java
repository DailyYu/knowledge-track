package com.knowledge.track.common.exception;

import com.knowledge.track.common.response.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(BizException.class)
    @ResponseBody
    public ResultResponse handleBizException(BizException e) {
        log.info(e.getMessage(), e);
        return ResultResponse.buildFailure(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultResponse handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ResultResponse.error();
    }
}
