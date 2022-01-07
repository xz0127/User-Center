package com.example.userCenter.service;

import com.example.userCenter.pojo.UserProfile;
import com.example.userCenter.rpcDomain.common.RespResult;
import com.example.userCenter.rpcDomain.req.UserProfileRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserProfileService extends BaseService<UserProfile, String> {

    RespResult getUserProfileInfo(String userId);

    RespResult updateUserProfile(String userId, UserProfileRequest userProfileReq);
}
