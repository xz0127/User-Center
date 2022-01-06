package com.example.demo.service.impl;

import com.example.demo.dao.UserProfileDao;
import com.example.demo.pojo.Address;
import com.example.demo.pojo.User;
import com.example.demo.pojo.UserPreference;
import com.example.demo.pojo.UserProfile;
import com.example.demo.rpcDomain.common.RespResult;
import com.example.demo.rpcDomain.common.ResultCode;
import com.example.demo.rpcDomain.req.UserProfileRequest;
import com.example.demo.rpcDomain.resp.UserProfileResp;
import com.example.demo.service.AddressService;
import com.example.demo.service.UserPreferenceService;
import com.example.demo.service.UserProfileService;
import com.example.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileServiceImpl extends BaseServiceImpl<UserProfile, String>
        implements UserProfileService {

    @Autowired
    private UserProfileDao userProfileDao;

    @Autowired
    @Lazy
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserPreferenceService userPreferenceService;

    @Override
    protected JpaRepository getRepository() {
        return userProfileDao;
    }

    @Override
    public RespResult getUserProfileInfo(String userId) {
        Optional<User> userOptional = userService.findById(userId);
        if (!userOptional.isPresent()) {
            return new RespResult(ResultCode.USER_NOT_EXIST);
        }
        User user = userOptional.get();
        UserProfile userProfile = userProfileDao.findById(userId).get();
        Address address = addressService.findById(userId).get();
        UserPreference userPreference = userPreferenceService.findById(userId).get();

        UserProfileResp respInfo = new UserProfileResp();

        BeanUtils.copyProperties(user, respInfo);
        BeanUtils.copyProperties(address, respInfo);
        BeanUtils.copyProperties(userProfile, respInfo);
        BeanUtils.copyProperties(userPreference, respInfo);

        return new RespResult(ResultCode.SUCCESS, respInfo);
    }

    @Override
    public RespResult updateUserProfile(String userId, UserProfileRequest userProfileReq) {
        Optional<User> userOptional = userService.findById(userId);
        if (!userOptional.isPresent()) {
            return new RespResult(ResultCode.USER_NOT_EXIST);
        }

        User user = userOptional.get();
        Address address = addressService.findById(userId).get();
        UserProfile userProfile = userProfileDao.findById(userId).get();
        UserPreference userPreference = userPreferenceService.findById(userId).get();

        BeanUtils.copyProperties(userProfileReq, user);
        BeanUtils.copyProperties(userProfileReq, address);
        BeanUtils.copyProperties(userProfileReq, userProfile);
        BeanUtils.copyProperties(userProfileReq, userPreference);

        userService.save(user);
        addressService.save(address);
        userProfileDao.save(userProfile);
        userPreferenceService.save(userPreference);

        return new RespResult(ResultCode.SUCCESS);
    }

}
