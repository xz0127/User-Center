package com.example.userCenter.service;

import com.example.userCenter.pojo.UserTag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserTagService extends BaseService<UserTag, String> {

    List<String> getUserTagList(String userId);

}
