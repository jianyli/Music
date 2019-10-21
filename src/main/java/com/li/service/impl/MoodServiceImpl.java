package com.li.service.impl;

import com.li.dao.MoodDao;
import com.li.dao.UserDao;
import com.li.dao.UserMoodRelDao;
import com.li.dto.MoodDto;
import com.li.entity.Mood;
import com.li.entity.User;
import com.li.entity.UserMoodRel;
import com.li.service.MoodService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class MoodServiceImpl implements MoodService {
    @Resource
    private MoodDao moodDao;
    @Resource
    private UserDao userDao;
    @Resource
    private UserMoodRelDao userMoodRelDao;
    @Resource
    private RedisTemplate redisTemplate;
    private static final String PRAISE_HASH_KEY = "com.li.music.mood.id.list.key";
    @Override
    public List<MoodDto> findAll() {
        List<Mood> moods = moodDao.findAll();


        return converModeDto(moods);
    }

    @Override
    public boolean praiseMood(String userId, String moodId) {
        UserMoodRel userMoodRel = new UserMoodRel();
        userMoodRel.setUserId(userId);
        userMoodRel.setMoodId(moodId);
        userMoodRelDao.save(userMoodRel);
        Mood mood = moodDao.findById(moodId);
        mood.setPraiseNum(mood.getPraiseNum() + 1);
        this.update(mood);
        return true;
    }

    @Override
    public boolean update(Mood mood) {

        return moodDao.update(mood);
    }

    @Override
    public Mood findById(String moodId) {
        return moodDao.findById(moodId);
    }
    //redis


    @Override
    public boolean praiseMoodForRedis(String userId, String moodId) {
        redisTemplate.opsForSet().add(PRAISE_HASH_KEY,moodId);
        redisTemplate.opsForSet().add(moodId,userId);
        return false;
    }

    @Override
    public List<MoodDto> findAllFroRedis() {
        List<Mood> moods = moodDao.findAll();
        if (CollectionUtils.isEmpty(moods)) {
            return Collections.EMPTY_LIST;
        }
        List<MoodDto> moodDtos = new ArrayList<>();
        for (Mood mood : moods) {
            MoodDto moodDto = new MoodDto();
            moodDto.setId(mood.getId());
            moodDto.setUserId(mood.getUserId());
            moodDto.setPublishTime(mood.getPublishTime());
            moodDto.setContent(mood.getContent());
            moodDto.setPraiseNum(mood.getPraiseNum() + redisTemplate.opsForSet().size(mood.getId()).intValue());
            User user = userDao.find(mood.getUserId());
            moodDto.setNickname(user.getNickname());
            moodDtos.add(moodDto);
        }
        return moodDtos;
    }

    /**
     * 类转化
     * @param moods
     * @return
     */
    private List<MoodDto> converModeDto(List<Mood> moods) {
        if (CollectionUtils.isEmpty(moods) == true) {
            return Collections.EMPTY_LIST;
        }
        List<MoodDto> moodDtos = new ArrayList<>();
        for (Mood mood : moods) {
            MoodDto moodDto = new MoodDto();
            moodDto.setId(mood.getId());
            moodDto.setUserId(mood.getUserId());
            moodDto.setPublishTime(mood.getPublishTime());
            moodDto.setContent(mood.getContent());
            moodDto.setPraiseNum(mood.getPraiseNum());
            User user = userDao.find(mood.getUserId());
            moodDto.setNickname(user.getNickname());
            moodDtos.add(moodDto);
        }
        return moodDtos;
    }
}
