package com.study.piple.piple.config;

import com.study.piple.piple.subscriber.DealMessageSubscribe;
import com.study.piple.piple.subscriber.OrderMessageSubscribe;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class SubscriberConfig {


    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory factory, MessageListenerAdapter orderAdapter, MessageListenerAdapter dealAdapter) {
        RedisMessageListenerContainer listener = new RedisMessageListenerContainer();
        listener.setConnectionFactory(factory);
        listener.addMessageListener(orderAdapter, new PatternTopic("order"));
        listener.addMessageListener(dealAdapter, new PatternTopic("deal"));
        return listener;
    }


    @Bean
    public MessageListenerAdapter orderAdapter(OrderMessageSubscribe orderMessage) {
        return new MessageListenerAdapter(orderMessage, "receiveMessage");
    }

    @Bean
    public MessageListenerAdapter dealAdapter(DealMessageSubscribe dealMessage) {
        return new MessageListenerAdapter(dealMessage, "receiveMessage");
    }

    @Bean
    public OrderMessageSubscribe orderMessage() {
        return new OrderMessageSubscribe();
    }

    @Bean
    public DealMessageSubscribe dealMessage() {
        return new DealMessageSubscribe();
    }
}
