package com.xiaowo.constant_learning;

/**
 * Created by gu.haiyan on 2017/8/11.
 */
public interface EnumValueDescribution {

    /**
     * 优惠券锁定状态
     */
    String USER_COUPON_LOCK_STATUS = "锁定状态【11:优惠券锁定状态正常 12:优惠券支付锁定中 13:优惠券分享锁定中】";
    /**
     * 分享状态
     */
    String COUPON_SHARE_STATUS = "分享状态【21：分享中 22：已领取 23：超时取消 24：已过期】";
    /**
     * 使用状态
     */
    String USER_COUPON_STATUS = "使用状态【31：未使用 32：已使用 33：已过期】";
    /**
     * 活动状态
     */
    String COUPON_ACTIVITY_STATUS = "活动状态【1：待发放 2：发放中 3：已结束】";
    /**
     * 活动的开启/关闭状态
     */
    String COUPON_ACTIVITY_OPEN_CLOSE_STATUS = "活动处于开启/关闭状态【1：开启 2：关闭】";
    /**
     * 平台来源
     */
    String PALTFORM_SOURCE ="平台来源【1：商户小程序 2：家园网小程序 3：云语 4：收吧h5】";
    /**
     * 用户是否可领状态
     */
    String USER_RECEIVE_STATUS = "用户是否可领状态【1:可领取 2:已领取 3:已抢光】";
    /**
     * 变更类型
     */
    String CHANGE_TYPE = "变更类型【1：赠送】";
    /**
     * 目标用户类型
     */
    String TARGET_TYPE= "目标类型【1：个人 2：群】";
    /**
     * 变更渠道
     */
    String CHANNEL = "变更渠道【1：公池 2：非公池】";
}
