package com.example.userCenter.service;

import com.example.userCenter.pojo.UserPreference;
import com.example.userCenter.rpcDomain.common.RespResult;
import com.example.userCenter.rpcDomain.req.UserPreferenceRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserPreferenceService extends BaseService<UserPreference, String> {

    RespResult getSettingByUserId(String userId);

    RespResult updateSetting(UserPreferenceRequest req, String userId);
}
