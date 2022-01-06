package com.example.demo.control;

import com.example.demo.common.utils.JwtTokenUtils;
import com.example.demo.rpcDomain.common.RespResult;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
@RequestMapping("/account")
@CrossOrigin
public class AccountController {

    @Autowired
    private UserService userService;

    @PostMapping("/center")
    @ResponseBody
    public RespResult accountCenter(@RequestHeader(name = JwtTokenUtils.AUTH_HEADER_KEY) String headerValue) {
        String userId = JwtTokenUtils.getUserIdByAuthorHead(headerValue);
        return userService.getAccountCenterInfo(userId);
    }
}
