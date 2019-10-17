package com.li.service;

import com.li.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface UserService {
    String search(Map map);
    int createUser(User user);
}
