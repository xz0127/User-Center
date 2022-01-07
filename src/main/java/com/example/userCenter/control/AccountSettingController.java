package com.example.userCenter.control;

import com.example.userCenter.common.utils.JwtTokenUtils;
import com.example.userCenter.rpcDomain.common.RespResult;
import com.example.userCenter.rpcDomain.req.UserPreferenceRequest;
import com.example.userCenter.rpcDomain.req.UserProfileRequest;
import com.example.userCenter.service.UserPreferenceService;
import com.example.userCenter.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/account/settings")
@CrossOrigin
public class AccountSettingController {

    private Logger logger = LoggerFactory.getLogger(AccountSettingController.class);

    @Autowired
    private UserPreferenceService userPreferenceService;

    @Autowired
    private UserProfileService userProfileService;

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

    @PostMapping(value = "/profile/show", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public RespResult showProfile(@RequestHeader(name = JwtTokenUtils.AUTH_HEADER_KEY) String headerValue) {
        String userId = JwtTokenUtils.getUserIdByAuthorHead(headerValue);
        return userProfileService.getUserProfileInfo(userId);
    }

    @PostMapping(value = "/profile/update", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public RespResult updateProfile(@RequestHeader(name = JwtTokenUtils.AUTH_HEADER_KEY) String headerValue,
                                    @RequestBody UserProfileRequest userProfileReq) {
        String userId = JwtTokenUtils.getUserIdByAuthorHead(headerValue);
//        List<String> validateMsg = BeanUtil.validateProperty(userProfileReq);
//        if (validateMsg.size() > 0) {
//            return new RespResult(ResultCode.PARAM_IS_BLANK, validateMsg);
//        }
        return userProfileService.updateUserProfile(userId, userProfileReq);
    }

}
