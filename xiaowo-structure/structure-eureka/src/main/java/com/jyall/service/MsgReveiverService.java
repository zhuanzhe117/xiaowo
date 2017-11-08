package com.jyall.service;

import com.alibaba.fastjson.JSON;
import com.jyall.api.sbeco.coupon.pojo.Coupon;
import com.jyall.constant.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by gu.haiyan on 2017/10/18.
 */
@Component
public class MsgReveiverService {

    private static Logger logger = LoggerFactory.getLogger(MsgReveiverService.class);

//    @RabbitListener(queues = Constant.USER_COUPON_RECEIVE_QUEUE)
//    public void ReceiveBindCoupon(@Payload Coupon coupon)throws Exception{
//        logger.info("接收到消息，{}", JSON.toJSON(coupon));
//    }
}
