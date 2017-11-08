package com.jyall.api.sbeco.couponactivity.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商家券活动实体类
 * Created by gu.haiyan on 2017/7/27.
 */
public class CouponActivity implements Serializable{

    private static final long serialVersionUID = -956732294944541090L;

    /**
     * 商家券活动ID
     */
    private String couponActivityId;

    /**
     * 商家券活动名称
     */
    private String couponActivityName;

    /**
     * 商户编号
     */
    private String merchantCode;

    /**
     * 商户名称
     */
    private String merchantName;

    /**
     *券类型CODE（现金券、满减券、满折券）
     */
    private String couponTypeCode;

    /**
     *券类型NAME（现金券、满减券、满折券）
     */
    private String couponTypeName;

    /**
     * 券面额
     */
    private BigDecimal couponDenomination;

    /**
     * 券张数
     */
    private int couponCount;

    /**
     *开始发放时间
     */
    private Date beginExtendTime;

    /**
     *结束发放时间
     */
    private Date endExtendTime;

    /**
     *生效时间
     */
    private Date timeOfTakingEffect;

    /**
     *失效时间
     */
    private Date outOfServiceTime;

    /**
     *状态（待发放，发放中，已结束）
     */
    private int status;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *更新时间
     */
    private Date updateTime;

    /**
     *使用范围
     */
    private String rangeOfUse;

    /**
     *使用说明
     */
    private String instructions;

    /**
     *领用限制
     */
    private int consumeCountLimit;

    /**
     * 已领
     */
    private int totalCollected;

    /**
     *已使用
     */
    private int totalUsed;

    /**
     *已作废
     */
    private int totalInvalid;

    /**
     *已过期
     */
    private int totalExpired;



}
