package com.jyall.api.sbeco.coupon.pojo;

import com.jyall.api.sbeco.couponactivity.pojo.CouponActivity;

import java.io.Serializable;
import java.util.Date;

/**
 * 优惠券实体类
 * Created by gu.haiyan on 2017/7/27.
 */
public class Coupon implements Serializable{


    private static final long serialVersionUID = -698125507047615937L;

    /**
     * 商家券ID
     */
    private String couponId;

    /**
     * 商家券名称
     */
    private String couponName;

    /**
     * 商家券活动
     */
    private CouponActivity couponActivity;

    /**
     * 流水号
     */
    private String flowNo;

    /**
     *流水应付金额
     */
    private String amountPayable;

    /**
     *使用状态(未使用、已使用，已过期)
     */
    private int status;

    /**
     *锁定状态（支付锁定、分享锁定、未锁定）
     */
    private int lockingStatus;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *更新时间
     */
    private Date useTime;

    /**
     *生效时间
     */
    private Date timeOfTakingEffect;

    /**
     *失效时间
     */
    private Date outOfServiceTime;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户手机号
     */
    private String userTel;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public CouponActivity getCouponActivity() {
        return couponActivity;
    }

    public void setCouponActivity(CouponActivity couponActivity) {
        this.couponActivity = couponActivity;
    }

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo;
    }

    public String getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(String amountPayable) {
        this.amountPayable = amountPayable;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLockingStatus() {
        return lockingStatus;
    }

    public void setLockingStatus(int lockingStatus) {
        this.lockingStatus = lockingStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public Date getTimeOfTakingEffect() {
        return timeOfTakingEffect;
    }

    public void setTimeOfTakingEffect(Date timeOfTakingEffect) {
        this.timeOfTakingEffect = timeOfTakingEffect;
    }

    public Date getOutOfServiceTime() {
        return outOfServiceTime;
    }

    public void setOutOfServiceTime(Date outOfServiceTime) {
        this.outOfServiceTime = outOfServiceTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }
}
