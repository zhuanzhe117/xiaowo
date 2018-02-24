package com.xiaowo.algorithms;

import ch.qos.logback.classic.net.SyslogAppender;

/**
 * Created by gu.haiyan on 2017/9/7.
 */
public class DynamicProgramming_CoinRow {
    public static void coinRow(int[] coinArr,int[] maxValue,int[] collection){


        for (int i = 0; i < coinArr.length; i++) {
            if(i==0){
                maxValue[i] = coinArr[i];
                collection[i] = 1;
            }else if(i == 1){
                maxValue[i] = coinArr[i-1] > coinArr[i] ? coinArr[i-1] : coinArr[i];
                collection[i] = coinArr[i-1] > coinArr[i] ? 0 : 1;
            }else {
                maxValue[i] = maxValue[i-1] > (coinArr[i] + maxValue[i-2]) ? maxValue[i-1] : coinArr[i] + maxValue[i-2];
                collection[i] = maxValue[i-1] > (coinArr[i] + maxValue[i-2]) ? 0 : 1;
            }
        }

    }

    public static void main(String[] args) {

        int[] coinArr = {5,1,2,10,6,2};
        int[] maxValue = new int[coinArr.length];//保存最大值
        int[] collection = new int[coinArr.length];//保存每一枚硬币的状态,1代表选取，0代表舍弃

        coinRow(coinArr,maxValue,collection);
        for (int i = 0; i < coinArr.length; i++) {
            System.out.print(maxValue[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < coinArr.length; i++) {
            if(collection[i] == 1) System.out.print(i + " ");
//            System.out.print(collection[i] + " ");
        }
    }
}
