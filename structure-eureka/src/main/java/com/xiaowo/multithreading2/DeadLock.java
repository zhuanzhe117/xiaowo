package com.xiaowo.multithreading2;

public class DeadLock implements Runnable{

    private int i=0;

    @Override
    public void run() {
        while(true) {
            if(i%2==0){
                synchronized(LockA.lockA) {
                    System.out.println("if...lockA");
                    synchronized(LockB.lockB) {
                        System.out.println("if...lockB");
                    }
                }
            }else {
                synchronized(LockB.lockB) {
                    System.out.println("else...lockB");
                    synchronized(LockA.lockA) {
                        System.out.println("else...lockA");
                    }
                }
            }
            i++;
        }

    }

    public static void main(String[] args) {
         DeadLock deadLock = new DeadLock();
         Thread t1 = new Thread(deadLock);
         Thread t2 = new Thread(deadLock);
         t1.start();
         t2.start();
     }
}
