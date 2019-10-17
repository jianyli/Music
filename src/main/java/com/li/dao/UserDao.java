package com.li.dao;

import com.li.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserDao {
    String search(Map map);
    int createUser(User user);
}
