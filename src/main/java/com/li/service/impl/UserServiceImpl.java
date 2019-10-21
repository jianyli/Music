package com.li.service.impl;

import com.li.dao.UserDao;
import com.li.entity.User;
import com.li.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public String search(Map map) {
        String nickname = userDao.search(map);
        return userDao.search(map);
    }

    @Override
    public int createUser(User user) {
        return userDao.createUser(user);
    }
}
