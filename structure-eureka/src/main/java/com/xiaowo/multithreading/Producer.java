package com.xiaowo.multithreading;

/**
 * 生产者
 */
public class Producer implements Runnable {
    SyncStack ss = null;
    Producer(SyncStack ss){
        this.ss=ss;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Apple apple = new Apple(i);
            ss.push(apple);
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
