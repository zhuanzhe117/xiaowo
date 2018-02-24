package com.jyall.api.sbeco.coupon.pojo;

import com.jyall.api.sbeco.couponactivity.pojo.CouponActivity;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家券用户变更记录实体类
 * Created by gu.haiyan on 2017/7/27.
 */
public class CouponChangeRecord implements Serializable{


    private static final long serialVersionUID = -698125507047615937L;

    /**
     * 商家券ID
     */
    private String couponId;

    /**
     * 序号
     */
    private int sharedNo;

    /**
     * 变更前用户ID
     */
    private String preUserId;

    /**
     * 变更前用户手机号
     */
    private String preUserTel;

    /**
     *变更前用户名称
     */
    private String preUserName;

    /**
     *变更后用户ID
     */
    private String sufUserId;

    /**
     *变更后用户手机号
     */
    private int lockingStatus;

    /**
     * 变更后用户名称
     */
    private String userId;

    /**
     * 变更时间
     */
    private Date updateTime;

    /**
     * 变更渠道
     */
    private int channel;


}
