package com.xiaowo.nonrecursive_mathematic_alanalysis;

/**
 * Created by gu.haiyan on 2017/7/12.
 */
public class examples {
    //2.3非递归算法的数学分析
    //例1 从n个元素的列表中查找元素最大值
    public static int getTheMostOne (int[] a ,int n){
        int maxval = a[0];
        for (int i = 1; i < n; i++) {
            if (maxval < a[i]){
                maxval = a[i];
            }
        }
        return maxval;
    }

    //例2 元素唯一性问题：验证给定数组中的n个元素是否全部唯一
    public static boolean isAllElementsUnique( int[] a ,int n){
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (a[i]==a[j]) return false;
            }
        }
        return true;
    }

    //例3 对于两个给定的n阶方阵A和B的乘积计算问题，求基于定义的算法的时间效率。




    public static void main(String[] args) {
        int[] a = {13,10,67,3,5};
//        int result = getTheMostOne(a,5);
//        System.out.println("result = [" + result + "]");

        boolean flag = isAllElementsUnique(a,5);
        System.out.println("flag = [" + flag + "]");


    }
}
