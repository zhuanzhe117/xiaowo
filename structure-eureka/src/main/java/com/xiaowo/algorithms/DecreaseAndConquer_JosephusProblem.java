package com.xiaowo.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gu.haiyan on 2017/7/21.
 */
public class DecreaseAndConquer_JosephusProblem {
    int count = 6;

    public static int getSurvivor(int count){
        //产生n个号码
        List<Integer> dataList = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            dataList.add(i);
        }
//        if(dataList.size()==1) return dataList.get(0);

        int total = dataList.size();
        boolean type = (total%2==0)?true:false;
        int index = 0;
        while(true){
            index++;
            dataList.remove(index);
            System.err.println(index);
            if(!type && index == (total/2)){			//偶数的话
                dataList.remove(0);
            }
            if(index == (total/2)){
                index = 0;//重新重二开始获取
                total = dataList.size();//新的总长度
                type = (total%2==0)?true:false;
            }
            if(dataList.size()==1){
                System.err.println("~~~~~~~~~~~"+dataList);
                return dataList.get(0);
            }
        }

    }

    public static void main(String[] args) {
        int result =getSurvivor(6);
    }

}
