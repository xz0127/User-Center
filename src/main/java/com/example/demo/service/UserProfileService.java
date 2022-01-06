package com.example.demo.service;

import com.example.demo.pojo.UserProfile;
import com.example.demo.rpcDomain.common.RespResult;
import com.example.demo.rpcDomain.req.UserProfileRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserProfileService extends BaseService<UserProfile, String> {

    RespResult getUserProfileInfo(String userId);

    RespResult updateUserProfile(String userId, UserProfileRequest userProfileReq);
}
