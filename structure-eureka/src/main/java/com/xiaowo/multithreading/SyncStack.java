package com.xiaowo.multithreading;

/**
 * 盛放苹果的栈容器
 */
public class SyncStack {

    int index = 0;//个数
    Apple[] arrApple = new Apple[6];

    public synchronized void push(Apple apple){
        while(index == arrApple.length ){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        arrApple[index] = apple;
        System.out.println("生产了" + apple);
        index++;
    }

    public synchronized Apple pop(){
        while (index == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        System.out.println("消费了：" + arrApple[index]);
        return arrApple[index];
    }

    public static void main(String[] args){
        SyncStack ss = new SyncStack();
        Producer p = new Producer(ss);
        Consumer c = new Consumer(ss);
        new Thread(p).start();
        new Thread(c).start();
    }
}
