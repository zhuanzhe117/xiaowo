package com.xiaowo.controller_learning;

import com.jyall.api.sbeco.coupon.pojo.Coupon;
import com.jyall.service.MsgReveiverService;
import com.jyall.service.MsgSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gu.haiyan on 2017/8/22.
 */
//返回数据，不返回视图，和@RestController一样
@Controller
public class UserController {
//
//    @RequestMapping(value = "/list")
//    @ResponseBody
//    public Coupon userList(){
//        Coupon coupon = new Coupon();
//        coupon.setCouponId("c101010");
//        coupon.setCouponName("2元优惠券");
//        return coupon;
//    }

    @Autowired
    private MsgSenderService msgSenderService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public String userList(){
        msgSenderService.bindCoupon();
        return "ok";
    }
}
//返回数据，不返回视图
//@RestController
//public class UserController {
//
//    @RequestMapping(value = "/list")
//    public Coupon userList(){
//        Coupon coupon = new Coupon();
//        coupon.setCouponId("c101010");
//        coupon.setCouponName("2元优惠券");
//        return coupon;
//    }
//}
//@Controller
//返回视图，即使里面有数据也没用
//public class UserController {
//
//    @RequestMapping(value = "/list")
//    public String userList(){
//        return "user_list";
//    }
//}
