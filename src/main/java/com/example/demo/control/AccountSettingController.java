package com.example.demo.control;

import com.example.demo.common.utils.JwtTokenUtils;
import com.example.demo.rpcDomain.common.RespResult;
import com.example.demo.rpcDomain.req.UserPreferenceRequest;
import com.example.demo.service.UserPreferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account/settings")
public class AccountSettingController {

    private Logger logger = LoggerFactory.getLogger(AccountSettingController.class);

    @Autowired
    private UserPreferenceService userPreferenceService;

    @PostMapping(value = "/notice/show", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public RespResult showNotice(@RequestHeader(name = JwtTokenUtils.AUTH_HEADER_KEY) String headerValue) {
        String userId = JwtTokenUtils.getUserIdByAuthorHead(headerValue);
        return userPreferenceService.getSettingByUserId(userId);
    }

    @RequestMapping(value = "/notice/update", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public RespResult showNotice(@RequestBody UserPreferenceRequest userPreferenceRequest,
                                 @RequestHeader(name = JwtTokenUtils.AUTH_HEADER_KEY) String headerValue) {
        String userId = JwtTokenUtils.getUserIdByAuthorHead(headerValue);
        return userPreferenceService.updateSetting(userPreferenceRequest, userId);
    }
}
