package com.example.demo.service;

import com.example.demo.pojo.UserPreference;
import com.example.demo.rpcDomain.common.RespResult;
import com.example.demo.rpcDomain.req.UserPreferenceRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserPreferenceService extends BaseService<UserPreference, String> {

    RespResult getSettingByUserId(String userId);

    RespResult updateSetting(UserPreferenceRequest req, String userId);
}
