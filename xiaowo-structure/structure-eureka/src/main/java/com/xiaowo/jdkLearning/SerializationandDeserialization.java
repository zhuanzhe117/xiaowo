package com.xiaowo.jdkLearning;

import com.jyall.api.sbeco.coupon.pojo.Coupon;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by gu.haiyan on 2017/9/1.
 */
public class SerializationandDeserialization {
    public static void main(String[] args) {
        Coupon coupon = new Coupon();
        coupon.setCouponName("ghy");
        coupon.setCouponId("111");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream os = new ObjectOutputStream(baos);
            os.writeObject(coupon);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
