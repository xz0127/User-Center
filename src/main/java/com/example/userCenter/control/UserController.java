package com.example.userCenter.control;

import com.example.userCenter.common.token.JwtIgnore;
import com.example.userCenter.common.utils.JwtTokenUtils;
import com.example.userCenter.pojo.User;
import com.example.userCenter.rpcDomain.common.RespResult;
import com.example.userCenter.rpcDomain.common.ResultCode;
import com.example.userCenter.rpcDomain.req.LoginRequest;
import com.example.userCenter.rpcDomain.req.RegisterRequest;
import com.example.userCenter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
@CrossOrigin
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="get/Captcha", method= RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @JwtIgnore
    public RespResult getCaptcha(@RequestBody RegisterRequest registerRequest) {
        return userService.beforeRegister(registerRequest);
    }

    @PostMapping(value="register", produces = {MediaType.APPLICATION_JSON_VALUE}) // map to post request
    @ResponseBody
    @JwtIgnore
    public RespResult register(@RequestBody RegisterRequest registerRequest) {
        try {
            if (!userService.checkCaptcha(registerRequest)) {
                return new RespResult(ResultCode.WRONG_CAPTCHA);
            }
        } catch (NullPointerException npe) {
            return new RespResult(ResultCode.REGISTER_RECORD_IS_EMPTY);
        }
        return userService.registerUser(registerRequest);
    }

    @PostMapping(value = "/login", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @JwtIgnore
    public RespResult login(HttpServletResponse response, @RequestBody LoginRequest loginRequest) {
        User user = userService.getByUsername(loginRequest.getUsername());
        if (!userService.checkVerified(user)) {
            return new RespResult(ResultCode.USER_INVALID);
        }
        // check password
        if (!userService.checkPassword(user, loginRequest)) {
            return new RespResult(ResultCode.USER_LOGIN_ERROR);
        }
        // generate token
        String token = JwtTokenUtils.createJWT(user.getId(), user.getUsername());
        logger.info("User : " + user.getUsername() + " login successfully");
        logger.info("token : " + token);

        // 将token放在响应头
        response.setHeader(JwtTokenUtils.AUTH_HEADER_KEY, JwtTokenUtils.TOKEN_PREFIX + token);
        // 将token响应给客户端
        Map<String, String> result = new HashMap();
        result.put("token", token);
        return new RespResult(ResultCode.LOGIN_SUCCESS, result);
    }

}
