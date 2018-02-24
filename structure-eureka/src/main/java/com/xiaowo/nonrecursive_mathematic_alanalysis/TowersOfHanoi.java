package com.xiaowo.nonrecursive_mathematic_alanalysis;

/**
 * Created by gu.haiyan on 2017/7/18.
 * 汉诺塔 递归调用
 */
public class TowersOfHanoi {
    static int i =1;
    public static void move(int n,char source,char target ){
        System.out.println("第" + (i++) + "次移动，把" + n +"号盘子从" + source + "移动到" + target);
    }

    public static void Hanoi(int n,char source ,char temp,char target){
        if(n==1){
            move(1,source,target);
        }else {
            Hanoi(n-1,source,target,temp);
            move(n,source,target);
            Hanoi(n-1,temp,source,target);
        }
    }

    public static void main(String[] args) {
        char from ='A';
        char temp = 'B';
        char to = 'C';
        int n = 4;
        System.out.println("请输入盘子个数：" + n);
        Hanoi(n,from,temp,to);
    }
}
