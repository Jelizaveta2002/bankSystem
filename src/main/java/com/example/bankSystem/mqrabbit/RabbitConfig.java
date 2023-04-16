package com.example.bankSystem.mqrabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String TOPIC_EXCHANGE_NAME = "my-exchange";
    public static final String ROUTING_KEY = "my-routing-key";

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    @Bean
    public Queue myQueue() {
        return new Queue("my-queue");
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(myQueue()).to(topicExchange()).with(ROUTING_KEY);
    }
}

