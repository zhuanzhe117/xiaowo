package com.xiaowo.algorithms;

/**
 * 金矿问题：
 * Created by gu.haiyan on 2017/7/6.
 */
public class DynamicProgramming_gold {

    //动态规划法求解
    public int getMostGoldByDP(int n, int w, int[] g, int[] p){

        int[] preResults = new int[w+1];
        int[] results = new int[w+1];

        for (int i = 0; i <= w; i++) {
            if (i < p[0]){
                preResults[i] = 0;
            }else {
                preResults[i] = g[0];
            }
            System.out.print(" " + preResults[i]);
        }
        System.out.println("");

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (j < p[i]){
                    results[j] = preResults[j];
                    System.out.print(" " + results[j]);
                }else {
                    results[j] = Math.max(preResults[j],preResults[j-p[i]] + g[i]);
                    System.out.print(" " + results[j]);
                }
            }
            preResults = results;
            System.out.println("");
        }
        return results[w];
    }


    public static void main(String[] args) {
        DynamicProgramming_gold dp = new DynamicProgramming_gold();
        int[] g = {1500,3000,2000};
        int[] p = {1,4,3};
        int gold = dp.getMostGoldByDP(3,4,g,p);
        System.out.println("最大价值是 " +gold);
    }
}
