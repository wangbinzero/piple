package com.study.piple.piple.config;

import com.study.piple.piple.handler.DealMessageReceiver;
import com.study.piple.piple.handler.OrderMessageReceiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class PublisherConfig {


    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory factory, MessageListenerAdapter orderAdapter, MessageListenerAdapter dealAdapter) {
        RedisMessageListenerContainer listener = new RedisMessageListenerContainer();
        listener.setConnectionFactory(factory);
        listener.addMessageListener(orderAdapter, new PatternTopic("order"));
        listener.addMessageListener(dealAdapter, new PatternTopic("deal"));
        return listener;
    }


    @Bean
    public MessageListenerAdapter orderAdapter(OrderMessageReceiver orderMessage) {
        return new MessageListenerAdapter(orderMessage, "receiveMessage");
    }

    @Bean
    public MessageListenerAdapter dealAdapter(DealMessageReceiver dealMessage) {
        return new MessageListenerAdapter(dealMessage, "receiveMessage");
    }

    @Bean
    public OrderMessageReceiver orderMessage() {
        return new OrderMessageReceiver();
    }

    @Bean
    public DealMessageReceiver dealMessage() {
        return new DealMessageReceiver();
    }
}
