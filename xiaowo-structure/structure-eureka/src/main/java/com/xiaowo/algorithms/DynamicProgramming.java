package com.xiaowo.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * 台阶问题：有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。要求用程序来求出一共有多少种走法。
 * Created by gu.haiyan on 2017/6/22.
 */
public class DynamicProgramming {

    //方法一：递归求解
    public int getResultByRecursion(int n){
        if (n <1) {
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return getResultByRecursion(n-1) + getResultByRecursion(n-2);
    }

    //方法二：备忘录法求解
    public int getResultByMap(int n, Map<Integer,Integer> map){
        if (n <1) {
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }else{
            int value = getResultByMap(n-1,map) + getResultByMap(n-2,map);
            map.put(n,value);
            return value;
        }
    }

    //方法三：动态规划法求解
    public int getResultByDP(int n){
        if (n <1) {
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }

        int a = 1;
        int b = 2;
        int temp = 0;

        for (int i = 3; i < n+1 ; i++) {
            temp = a + b;
            a = b;
            b= temp;
        }
        return temp;
    }


    public static void main(String[] args) {
        DynamicProgramming dp = new DynamicProgramming();
        Map<Integer,Integer> map = new HashMap<>();
        long t1 = System.currentTimeMillis();
        System.out.println("调用前时间： " + t1);
        int s = dp.getResultByRecursion(10);
        long t2 = System.currentTimeMillis();
        System.out.println("调用后时间： " + t2);
        System.out.println("耗时： " + (t2-t1));
        System.out.println("s = [" + s + "]");
    }
}
