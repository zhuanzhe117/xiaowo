package com.jyall.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by gu.haiyan on 2017/10/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EurekaApp.class)
public class MsgSenderServiceTest {
    @Autowired
    private MsgSenderService msgSenderService;

    @Test
    public void test(){
        msgSenderService.bindCoupon();
    }
}
