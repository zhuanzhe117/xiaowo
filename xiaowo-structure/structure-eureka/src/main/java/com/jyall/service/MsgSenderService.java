package com.jyall.service;

import com.alibaba.fastjson.JSON;
import com.jyall.api.sbeco.coupon.pojo.Coupon;
import com.jyall.constant.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by gu.haiyan on 2017/10/18.
 */
@Service
public class MsgSenderService {

    private static Logger logger = LoggerFactory.getLogger(MsgSenderService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void bindCoupon(){
        Coupon coupon = new Coupon();
        coupon.setCouponId("12345678");
        rabbitTemplate.convertAndSend(Constant.USER_COUPON_EXCHANGE,Constant.USER_COUPON_RECEIVE_ROUT_KEY,coupon);
        logger.info("发送消息， " + JSON.toJSON(coupon));

    }
}
