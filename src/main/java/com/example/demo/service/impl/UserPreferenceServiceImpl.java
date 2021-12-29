package com.example.demo.service.impl;

import com.example.demo.dao.UserPreferenceDao;
import com.example.demo.pojo.UserPreference;
import com.example.demo.service.UserPreferenceService;
import com.example.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPreferenceServiceImpl
        extends BaseServiceImpl<UserPreference, String>
        implements UserPreferenceService {

    @Autowired
    UserPreferenceDao userPreferenceDao;

    @Override
    protected JpaRepository getRepository() {
        return userPreferenceDao;
    }

//    @Override
//    public RespResult<UserPreferenceResp> getByUserId(String userId) {
//        if (StringUtils.isEmpty(userId)) {
//            return new RespResult<>(ResultCode.PARAM_IS_BLANK);
//        }
//        Optional<User> user = userService.findById(userId);
//        if (!user.isPresent()) {
//            return new RespResult(ResultCode.FAIL, "没有查到该用户的设置信息");
//        }
//        Optional<UserPreference> entity = userPreferenceDao.findById(user.get().getId());
//        UserPreferenceResp resp = new UserPreferenceResp();
//        BeanUtils.copyProperties(entity.get(), resp);
//        return new RespResult(ResultCode.SUCCESS, resp);
//    }
//
//    @Override
//    public RespResult updateSetting(UserPreferenceReq req, String userId) {
//        UserPreference userPreference = new UserPreference();
//        BeanUtils.copyProperties(req, userPreference);
//        userPreference.setUserId(userId);
//        userPreferenceDao.save(userPreference);
//        return new RespResult(ResultCode.SUCCESS);
//    }
}
