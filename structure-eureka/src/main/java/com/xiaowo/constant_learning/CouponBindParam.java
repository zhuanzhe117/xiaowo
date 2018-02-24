package com.xiaowo.constant_learning;

import com.wordnik.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

import static com.xiaowo.constant_learning.EnumValueDescribution.PALTFORM_SOURCE;

/**
 * Created by gu.haiyan on 2017/8/11.
 */
public class CouponBindParam implements Serializable {

    @ApiModelProperty(value = "serialVersionUID")
    private static final long serialVersionUID = -5779410519641855669L;
    /**
     * 优惠券活动ID
     */
    @ApiModelProperty(value = "优惠券活动ID")
    @NotBlank
    private String couponActivityId;

    /**
     * openId(商户小程序必传)
     */
    @ApiModelProperty(value = "openId(商户小程序必传)")
    private String openId;

    /**
     * 平台来源
     */
    @ApiModelProperty(value = PALTFORM_SOURCE)
    @NotBlank
    private int source;

    /**
     * unionId(除了商户小程序，其余平台必传)
     */
    @ApiModelProperty(value = "unionId(除了商户小程序，其余平台必传)")
    private String unionId;

    /**
     * 用户手机号
     */
    @ApiModelProperty(value = "用户手机号")
    private String userTel;

    public String getCouponActivityId() {
        return couponActivityId;
    }

    public void setCouponActivityId(String couponActivityId) {
        this.couponActivityId = couponActivityId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }
}
