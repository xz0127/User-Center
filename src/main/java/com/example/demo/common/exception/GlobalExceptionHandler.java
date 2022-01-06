package com.example.demo.common.exception;

import com.example.demo.rpcDomain.common.RespResult;
import com.example.demo.rpcDomain.common.ResultCode;
import com.fasterxml.jackson.core.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    public RespResult handleException(Exception e, HttpServletResponse response, HttpServletRequest request) {
        addHeader(response, request);
        if (e instanceof HttpRequestMethodNotSupportedException) {
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            return new RespResult(ResultCode.HTTP_METHOD_NOT_ALLOWED);
        } else if (e instanceof JsonParseException) {
            return new RespResult(ResultCode.JSON_FORMAT_ERROR);
        } else if (e instanceof CustomException) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return new RespResult(((CustomException) e).getResultCode());
        } else if (e instanceof MissingServletRequestParameterException) {
            return new RespResult(ResultCode.REQ_PARAM_IS_BLANK);
        } else if (e instanceof MethodArgumentNotValidException) {
            return new RespResult(ResultCode.PARAM_TYPE_BIND_ERROR,
                    ((MethodArgumentNotValidException) e).getBindingResult());
        } else if (e instanceof HttpMediaTypeNotSupportedException) {
            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            return new RespResult(ResultCode.HTTP_MEDIA_TYPE_NOT_SUPPORT);
        } else if (e instanceof NoHandlerFoundException) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return new RespResult(ResultCode.INTERFACE_ADDRESS_INVALID);
        } else if (e instanceof HttpMessageNotReadableException) {
            response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
            return new RespResult(ResultCode.MSG_NOT_ACCEPT);
        } else {
            return new RespResult(ResultCode.GENERAL_ERROR);
        }
    }

    public void addHeader(HttpServletResponse response, HttpServletRequest request){
        response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
    }
}
