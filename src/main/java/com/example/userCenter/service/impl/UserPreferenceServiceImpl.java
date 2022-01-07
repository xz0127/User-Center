package com.example.userCenter.service.impl;

import com.example.userCenter.dao.UserPreferenceDao;
import com.example.userCenter.pojo.User;
import com.example.userCenter.pojo.UserPreference;
import com.example.userCenter.rpcDomain.common.RespResult;
import com.example.userCenter.rpcDomain.common.ResultCode;
import com.example.userCenter.rpcDomain.req.UserPreferenceRequest;
import com.example.userCenter.rpcDomain.resp.UserPreferenceResp;
import com.example.userCenter.service.UserPreferenceService;
import com.example.userCenter.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPreferenceServiceImpl
        extends BaseServiceImpl<UserPreference, String>
        implements UserPreferenceService {

    @Autowired
    private UserPreferenceDao userPreferenceDao;

    @Autowired
    @Lazy
    private UserService userService;

    @Override
    protected JpaRepository getRepository() {
        return userPreferenceDao;
    }

    @Override
    public RespResult<UserPreferenceResp> getSettingByUserId(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return new RespResult<>(ResultCode.PARAM_IS_BLANK);
        }
        Optional<User> user = userService.findById(userId);
        if (!user.isPresent()) {
            return new RespResult(ResultCode.FAIL, "User not exists");
        }
        Optional<UserPreference> entity = userPreferenceDao.findById(user.get().getId());
        UserPreferenceResp resp = new UserPreferenceResp();
        BeanUtils.copyProperties(entity.get(), resp);
        return new RespResult(ResultCode.SUCCESS, resp);
    }

    @Override
    public RespResult updateSetting(UserPreferenceRequest req, String userId) {
        UserPreference userPreference = new UserPreference();
        BeanUtils.copyProperties(req, userPreference);
        userPreference.setUserId(userId);
        userPreferenceDao.save(userPreference);
        return new RespResult(ResultCode.SUCCESS);
    }
}
