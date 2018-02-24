package com.jyall.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

import static com.jyall.constant.Constant.*;

/**
 * @author lihao
 * @since 2017-07-28 13:25
 */
@Configuration
public class RabbitMQConfig {
    private static final Map<String, Object> args = new HashMap<>();

    /**
     * constructor
     */
    public RabbitMQConfig(){
        args.put("x-dead-letter-exchange",USER_COUPON_EXCHANGE);
    }
    /**
     * 消息转换
     * @return
     */
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    Queue dlxQueue() {
        return new Queue(USER_COUPON_RECEIVE_ROUT_KEY, true);
    }
//    @Bean
//    Queue sysMsgReceive(){ return new Queue(USER_COUPON_RECEIVE_SYSMSG_QUEUE);}

//    @Bean
//    TopicExchange exchange() {
//        return new TopicExchange(SBECO_MARKET_EXCHANGE);
//    }
    @Bean
    DirectExchange dlxExchange() {
        return new DirectExchange(USER_COUPON_EXCHANGE);
    }

    @Bean
    Binding dlxBinding() {
        return BindingBuilder.bind(dlxQueue()).to(dlxExchange()).with(USER_COUPON_RECEIVE_ROUT_KEY);
    }

//    @Bean
//    Binding sysMsgReceiveBinding(){
//        return BindingBuilder.bind(sysMsgReceive()).to(exchange()).with(USER_COUPON_RECEIVE_ROUT_KEY);
//    }
}
