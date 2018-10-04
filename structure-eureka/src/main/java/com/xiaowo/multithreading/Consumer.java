package com.xiaowo.multithreading;

/**
 * 消费者
 */
public class Consumer implements Runnable {

    SyncStack ss = null;

    Consumer (SyncStack ss){
        this.ss = ss;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Apple apple = ss.pop();
            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
