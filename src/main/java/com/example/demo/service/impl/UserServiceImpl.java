package com.example.demo.service.impl;

import com.example.demo.common.strategy.ContextMapper;
import com.example.demo.common.strategy.OperatorStrategyEnum;
import com.example.demo.common.utils.MD5Utils;
import com.example.demo.common.utils.UUIDUtils;
import com.example.demo.component.exception.ValidateException;
import com.example.demo.component.validation.ReqValidateManager;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.*;
import com.example.demo.rpcDomain.common.RespResult;
import com.example.demo.rpcDomain.common.ResultCode;
import com.example.demo.rpcDomain.req.LoginRequest;
import com.example.demo.rpcDomain.req.RegisterRequest;
import com.example.demo.rpcDomain.resp.ArticleResp;
import com.example.demo.rpcDomain.resp.UserCenterDTOResp;
import com.example.demo.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, String>
        implements UserService {

    @Autowired
    private ReqValidateManager reqValidateManager;

    @Autowired
    private ToolService toolService;

    @Autowired
    private RegisterRecordService registerRecordService;

    @Autowired
    private ContextMapper contextMapper;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserPreferenceService userPreferenceService;

    @Autowired
    private UserTagService userTagService;

    @Autowired
    private UserProfileService userProfileService;

    @Override
    public RespResult beforeRegister(RegisterRequest registerRequest) {
        // check parameter
        try {
            reqValidateManager.doExecute(registerRequest);
        } catch (ValidateException ex) {
            return new RespResult(ex.getResultCode());
        }

        // send email
        boolean isSend = toolService.sendRegisterMail(registerRequest);
        // strategy pattern
        OperatorStrategyEnum context = isSend ? OperatorStrategyEnum.SUCCESS : OperatorStrategyEnum.EMAIL_FAIL;
        return contextMapper.loadProcessor(context).doProcess(registerRequest, context);
    }

    @Override
    public boolean checkCaptcha(RegisterRequest registerRequest) throws NullPointerException {
        String captcha = registerRecordService.getCaptchaByUsername(registerRequest.getUsername());
        return StringUtils.equals(captcha, registerRequest.getCaptcha());
    }

    @Override
    public RespResult registerUser(RegisterRequest registerRequest) {
        User user = userDao.getByUsername(registerRequest.getUsername());
        user.setVerified(Boolean.TRUE);
        userDao.save(user);
        initUserInfo(user);
        return new RespResult(ResultCode.REGISTERED_SUCCESS);
    }

    @Override
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public boolean checkVerified(User user) {
        return user != null && user.getVerified();
    }

    @Override
    public boolean checkPassword(User user, LoginRequest loginRequest) {
        return StringUtils.equals(user.getPassword(), MD5Utils.getMD5(loginRequest.getPassword()));
    }

    @Override
    public RespResult getAccountCenterInfo(String userId) {
        UserCenterDTOResp dtoResp = new UserCenterDTOResp();
        Optional<User> optionalUser = userDao.findById(userId);
        if (!optionalUser.isPresent()) {
            return new RespResult(ResultCode.USER_NOT_EXIST);
        }
        BeanUtils.copyProperties(optionalUser.get(), dtoResp);
        Address address = addressService.findById(userId).get();
        String res = (address.getProvince() == null ? "" : address.getProvince()) + (address.getCity() == null ? "" : address.getCity());
        if (StringUtils.isNotBlank(res)) {
            dtoResp.setProvinceAndCity(res);
        }
        dtoResp.setPersonalProfile(userProfileService.findById(userId).get().getPersonalProfile());
        List<ArticleResp> articleList = new ArrayList<>();
        ArticleResp articleResp;
        for (Article recentPublishedArticle : articleService.getRecentPublishedArticles()) {
            articleResp = new ArticleResp();
            BeanUtils.copyProperties(recentPublishedArticle, articleResp);
            articleList.add(articleResp);
        }
        List<String> userTagList = userTagService.getUserTagList(userId);

        dtoResp.setArticleList(articleList);
        if (userTagList != null && userTagList.size() > 0) {
            dtoResp.setUserTagList(userTagList);
        }
        return new RespResult(ResultCode.SUCCESS, dtoResp);
    }

    private void initUserInfo(User user) {
        String userId = user.getId();
        Address address = new Address();
        address.setUserId(userId);

        UserPreference userPreference = new UserPreference();
        userPreference.setUserId(userId);

        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(userId);

        userPreference.setSysMessageNotice("1");
        userPreference.setTodoNotice("1");
        userPreference.setOtherUserMessageNotice("1");

        UserTag userTag = new UserTag();
        userTag.setId(UUIDUtils.get());
        userTag.setUserId(userId);

        addressService.save(address);
        userPreferenceService.save(userPreference);
        userProfileService.save(userProfile);
        userTagService.save(userTag);
    }

    @Override
    protected JpaRepository getRepository() {
        return userDao;
    }
}
