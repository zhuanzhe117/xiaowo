package com.xiaowo.algorithms;

/**
 * 01背包问题：有一个背包可盛的重量为4，现有3个物品，重量和价值如下表，问：如何让包内装入的物品具有最大的总价值？
 * Created by gu.haiyan on 2017/7/10.
 */
public class DynamicProgramming_01bag {

    //动态规划法求解
    public static int getMostValueByDP(int n, int w, int[] values, int[] weights){

        int[] preResults = new int[w+1];
        int[] results = new int[w+1];

        //填充表格第一行，也就是只有一个物品的情况
        for (int i = 1; i <= w; i++) {
            if (i < weights[0]){
                preResults[i] = 0;
            }else {
                preResults[i] = values[0];
            }
            System.out.print(" " + preResults[i]);
        }
        System.out.println("");

        //填充表格剩余行数
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < weights[i]){
                    results[j] = preResults[j];
                    System.out.print(" " + results[j]);
                }else {
                    results[j] = Math.max(preResults[j],preResults[j-weights[i]] + values[i]);
                    System.out.print(" " + results[j]);
                }
            }
            preResults = results;
            System.out.println("");
        }
        return results[w];
    }

    public static void main(String[] args) {
        int[] g = {1500,3000,2000};
        int[] p = {1,4,3};
        int gold = getMostValueByDP(3,4,g,p);
        System.out.println("最大价值是 " +gold);
    }
}
