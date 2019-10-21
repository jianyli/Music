package com.li.activemq;

import com.li.dto.MoodDto;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.logging.Logger;
@Component
public class MoodConsumer implements MessageListener {
    private Logger logger = Logger.getLogger(String.valueOf(this.getClass()));
    private static final String PRAISE_HASH_KEY = "com.li.music.mood.id.list.key";
    @Resource
    private RedisTemplate redisTemplate;
    @Override
    public void onMessage(Message message) {
        try {
            MoodDto moodDto = (MoodDto) ((ActiveMQObjectMessage) message).getObject();
            redisTemplate.opsForSet().add(PRAISE_HASH_KEY,moodDto.getId());
            redisTemplate.opsForSet().add(moodDto.getId(),moodDto.getUserId());
            logger.info("-----------------消费者：" + moodDto.getUserId() + "点赞说说：" + moodDto.getId() + "______________");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
