package com.li.dao;

import com.li.entity.Mood;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoodDao {
    List<Mood> findAll();
    Mood findById(String id);
    boolean update(Mood mood);
}
