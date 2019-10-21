package com.li.service.impl;

import com.li.dao.UserMoodRelDao;
import com.li.entity.UserMoodRel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserMoodServiceImpl implements UserMoodRelDao {
    @Resource
    private UserMoodRelDao userMoodRelDao;
    @Override
    public boolean save(UserMoodRel userMoodRel) {
        return userMoodRelDao.save(userMoodRel);
    }
}
