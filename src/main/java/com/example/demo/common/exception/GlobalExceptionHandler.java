package com.example.demo.common.exception;

import com.example.demo.rpcDomain.common.RespResult;
import com.example.demo.rpcDomain.common.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    public RespResult handleException(Exception e, HttpServletResponse response, HttpServletRequest request) {
        logger.info(e.getMessage());
        if (e instanceof CustomException) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return new RespResult(((CustomException) e).getResultCode());
        }

        return new RespResult(ResultCode.GENERAL_ERROR);
    }
}
