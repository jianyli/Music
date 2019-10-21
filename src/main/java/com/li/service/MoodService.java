package com.li.service;

import com.li.dto.MoodDto;
import com.li.entity.Mood;

import java.util.List;

public interface MoodService {
    boolean praiseMood(String userId ,String moodId);
    Mood findById(String moodId);
    boolean update(Mood mood);
    List<MoodDto> findAll();

    //redis实现
    boolean praiseMoodForRedis(String userId,String moodId);
    List<MoodDto> findAllFroRedis();
}
