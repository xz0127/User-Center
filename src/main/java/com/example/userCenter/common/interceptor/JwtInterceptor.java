package com.example.userCenter.common.interceptor;

import com.example.userCenter.common.exception.CustomException;
import com.example.userCenter.common.token.JwtIgnore;
import com.example.userCenter.common.utils.JwtTokenUtils;
import com.example.userCenter.rpcDomain.common.ResultCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            JwtIgnore annotation = handlerMethod.getMethodAnnotation(JwtIgnore.class);
            if (annotation != null) {
                return true;
            }
        }
        String authHeader = request.getHeader(JwtTokenUtils.AUTH_HEADER_KEY);
        if (StringUtils.isBlank(authHeader) || !authHeader.startsWith(JwtTokenUtils.TOKEN_PREFIX)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            logger.info("User not logged in.");
            throw new CustomException(ResultCode.USER_NOT_LOGGED_IN);
        }
        String token = authHeader.substring(7);
        boolean isExpired = JwtTokenUtils.isExpiration(token);
        if (isExpired) {
            logger.info("Token has expired.");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }
}
