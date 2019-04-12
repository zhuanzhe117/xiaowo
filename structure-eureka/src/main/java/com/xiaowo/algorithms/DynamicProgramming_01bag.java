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
            preResults = results.clone();
            System.out.println("");
        }
        return results[w];
    }

    /**
     * 使用二维数组实现，并打印最优解的构成
     * @param n
     * @param w
     * @param values
     * @param weights
     */
    public static void getMostValueByDP1(int n, int w, int[] values, int[] weights){
        int[][] v = new int[n+1][w+1];
        for (int i =0;i<=n;i++){//第0行和第0列初始化为0，方便后续第一个物品计算时取前面一行的值
            v[i][0] = 0;
        }
        for (int j =0;j<=w;j++){
            v[0][j] =0;
        }
        for (int i =1;i<=n;i++){//真正开始填充表格，计算每个格子的最大价值
            for (int j =1;j<=w;j++){
                if (weights[i-1]>j){
                    v[i][j] = v[i-1][j];
                }else {
                    v[i][j] = Math.max(values[i-1] + v[i-1][j-weights[i-1]],v[i-1][j]);
                }
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }
        int[] exists = new int[n];//打印最优解构成，倒着计算，如果v[i][w] > v[i-1][w]，说明第i个物品在背包中。
        for (int i =n;i>0;i--){
            if(v[i][w] > v[i-1][w]){
                exists[i-1] = 1;
                w = w - weights[i-1];
            }else {
                exists[i-1] = 0;
            }
            System.out.print(exists[i-1] + ",");
        }
    }
    public static void main(String[] args) {
        int[] values = {1000, 2000, 3000, 4000, 1500, 5000, 200, 400};
        int[] weights = {1, 3, 4, 2, 5, 4, 5, 1};
//        int gold = getMostValueByDP(3,4,g,p);
//        System.out.println("最大价值是 " +gold);
        getMostValueByDP1(values.length,4,values,weights);
    }
}
