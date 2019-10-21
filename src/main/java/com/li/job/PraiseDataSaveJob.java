package com.li.job;

import com.li.dao.MoodDao;
import com.li.dao.UserMoodRelDao;
import com.li.entity.Mood;
import com.li.entity.UserMoodRel;
import com.li.service.MoodService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Set;

@Component
@EnableScheduling
@Configurable
public class PraiseDataSaveJob {
    private static final String PRAISE_HASH_KEY = "com.li.music.mood.id.list.key";
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private UserMoodRelDao userMoodRelDao;
    @Resource
    private MoodService moodService;
    @Scheduled(cron = "*/3 * * * * *")
    public void praiseDataSaveDb() {
        Set<String> moods = redisTemplate.opsForSet().members(PRAISE_HASH_KEY);
        if (CollectionUtils.isEmpty(moods)) {
            return;
        }
        for (String moodId : moods) {
            if (redisTemplate.opsForSet().members(moodId) == null) {
                continue;
            } else {
                Set<String> users = redisTemplate.opsForSet().members(moodId);
                if (CollectionUtils.isEmpty(users)) {
                    continue;
                } else {
                    for (String userId : users) {
                        UserMoodRel userMoodRel = new UserMoodRel();
                        userMoodRel.setMoodId(moodId);
                        userMoodRel.setUserId(userId);
                        userMoodRelDao.save(userMoodRel);
                    }
                    Mood mood = moodService.findById(moodId);
                    mood.setPraiseNum(mood.getPraiseNum() + redisTemplate.opsForSet().size(moodId).intValue());
                    moodService.update(mood);
                    redisTemplate.delete(moodId);
                }
            }
        }
        redisTemplate.delete(PRAISE_HASH_KEY);
    }
}
