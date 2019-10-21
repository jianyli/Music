package com.li.activemq;

import com.li.dto.MoodDto;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.print.attribute.standard.Destination;
import java.util.Queue;
import java.util.logging.Logger;

@Component
public class MoodProduce {
    @Resource
    private JmsTemplate jmsTemplate;
    private Logger logger = Logger.getLogger(String.valueOf(this.getClass()));

    public void sendMessage(Queue queue, final MoodDto moodDto) {
        logger.info("-------------用户：" + moodDto.getUserId() + "给说说:" + moodDto.getId() + "点赞————————————————————————");
        jmsTemplate.convertAndSend(queue, (MessagePostProcessor) moodDto);
    }
}
