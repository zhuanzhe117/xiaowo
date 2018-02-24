package com.xiaowo.jdkLearning;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.hash;

/**
 * Created by gu.haiyan on 2017/8/8.
 */
public class NumCounterTest {

//    public static void main(String[] args) {
//        String arr = "12%3 21sdas s34d dfsdz45   R3 jo34 sjkf8 3$1P 213ikflsd fdg55 kfd";
//        Stream<Character> stream = IntStream.range(0, arr.length()).mapToObj(arr::charAt);
//        System.out.println("ordered total: " + countNum(stream));
//    }
//
//    private static int countNum(Stream<Character> stream){
//        NumCounter numCounter = stream.reduce(new NumCounter(0, 0, false), NumCounter::accumulate, NumCounter::combine);
//        return numCounter.getSum();
//    }

    public static void main(String[] args) {
//        List<Integer> list1 =new ArrayList<>();
//        long time1 = System.currentTimeMillis();
//        for (int i = 0; i < 30000; i++) {
//            list1.add(0,i);
//        }
//        long time11 = System.currentTimeMillis();
//        System.out.println("time1 = [" + (time11-time1) + "]");
//
//        List<Integer> list2 = new LinkedList<>();
//        long time2 = System.currentTimeMillis();
//        for (int i = 0; i < 30000; i++) {
//            list2.add(0,i);
//
//        }
//        long time22 = System.currentTimeMillis();
//        System.out.println("time2 = [" + (time22-time2) + "]");

    }

    static Class<?> comparabaa(Object x) {
        if (x instanceof Comparable) {
            Class<?> c; Type[] ts, as; Type t; ParameterizedType p;
            if ((c = x.getClass()) == String.class) // bypass checks
                return c;
            if ((ts = c.getGenericInterfaces()) != null) {
                for (int i = 0; i < ts.length; ++i) {
                    if (((t = ts[i]) instanceof ParameterizedType) &&
                            ((p = (ParameterizedType)t).getRawType() ==
                                    Comparable.class) &&
                            (as = p.getActualTypeArguments()) != null &&
                            as.length == 1 && as[0] == c) // type arg is c
                        return c;
                }
            }
        }
        return null;
    }

}
