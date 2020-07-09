package com.suruomo.amqp.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author suruomo
 * @date 2020/7/9 19:05
 * @description:
 */
@Configuration
public class MyAMQPConfig {

    @Bean
    public MessageConverter messageConverter(){
        //转为json
        return new Jackson2JsonMessageConverter();
    }
}
