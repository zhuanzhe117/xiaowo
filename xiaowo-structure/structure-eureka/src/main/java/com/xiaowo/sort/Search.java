package com.xiaowo.sort;

/**
 * Created by gu.haiyan on 2017/7/24.
 */
public class Search {

    /**
     * 蛮力字符串匹配
     * @param text
     * @param pattern
     * @return
     */
    public static int BruteForceStringMatch(char[] text,char[] pattern){
        for (int i = 0; i < (text.length-pattern.length); i++) {
            int j =0;
            while (j<pattern.length && text[i+j] == pattern[j]){
                j+=1;
            }
            if(j==pattern.length) return i;
        }
        return -1;
    }

    public static void main(String[] args){

        char[] text ={'h','e','l','l','o','w','o','r','l','d'};
        char[] pattern ={'w','o','r'};

        int p = BruteForceStringMatch(text,pattern);
        System.out.println("匹配结果： = [" + p + "]");
    }
}

