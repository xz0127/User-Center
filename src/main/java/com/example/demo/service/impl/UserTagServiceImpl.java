package com.example.demo.service.impl;

import com.example.demo.dao.UserTagDao;
import com.example.demo.pojo.UserTag;
import com.example.demo.service.UserTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTagServiceImpl
        extends BaseServiceImpl<UserTag, String>
        implements UserTagService {

    @Autowired
    private UserTagDao userTagDao;

    @Override
    protected JpaRepository getRepository() {
        return userTagDao;
    }

    @Override
    public List<String> getUserTagList(String userId) {
        return userTagDao.getUserTagList(userId);
    }
}
