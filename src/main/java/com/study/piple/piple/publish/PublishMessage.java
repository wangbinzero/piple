package com.study.piple.piple.publish;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class PublishMessage {

    private final RedisTemplate<String, Object> redisTemplate;

    public PublishMessage(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 发送消息
     *
     * @param topic   主体
     * @param message 消息
     */
    public void publishMessage(String topic, Object message) {
        redisTemplate.convertAndSend(topic, message);
    }
}
