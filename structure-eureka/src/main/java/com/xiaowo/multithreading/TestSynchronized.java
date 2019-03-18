package com.xiaowo.multithreading;

public class TestSynchronized{
    public void test1(){
        synchronized(this){
            int i = 5;
            while( i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                }catch (InterruptedException ie)
                {}
            }
        }
    }
    public synchronized void test2(){
        int i = 5;
        while( i-- > 0)        {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            }catch (InterruptedException ie)
            {
            }
        }
    }
    public void test3(){
        int i = 5;
        while( i-- > 0)        {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            }catch (InterruptedException ie)
            {
            }
        }
    }

    public void test4()
    {
        synchronized(TestSynchronized.class)
        {
            int i = 5;
            while( i-- > 0)
            {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException ie)
                {
                }
            }
        }
    }
    public static synchronized void test5()
    {
        int i = 5;
        while( i-- > 0)
        {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException ie)
            {
            }
        }
    }

    public static synchronized void test6()
    {
        int i = 5;
        while( i-- > 0)
        {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException ie)
            {
            }
        }
    }
    public static void main(String[] args)
    {
        //第一个同步代码块传入的对象实例this,第二个方法是修饰方法的方式进行同步.
        //所以两个同步代码所需要获得的对象锁都是同一个对象锁.
        //两个线程都需要获得该对象锁，一个线程获得对象锁后，另一个线程必须等待.
//        final TestSynchronized myt2 = new TestSynchronized();
//        Thread test1 = new Thread(  new Runnable() {  public void run() {  myt2.test1();  }  }, "test1"  );
//        Thread test2 = new Thread(  new Runnable() {  public void run() { myt2.test2();   }  }, "test2"  );
//        test1.start();;
//        test2.start();

        //---------------------------------------------------------------------------------------
        //void3上没有synchronized关键字时，某个线程得到了对象锁，但是另一个线程还是可以访问没有进行同步的方法或者代码
        //当获取到与对象关联的内置锁时，并不能阻止其他线程访问该对象，当某个线程获得对象的锁之后，只能阻止其他线程获得同一个锁。
        //synchronized只是一个内置锁的加锁机制，当某个方法加上synchronized关键字后，就表明要获得该内置锁才能执行，并不能阻止其他线程访问不需要获得该内置锁的方法。
//        final TestSynchronized myt2 = new TestSynchronized();
//        Thread test1 = new Thread(  new Runnable() {  public void run() {  myt2.test1();  }  }, "test1"  );
//        Thread test2 = new Thread(  new Runnable() {  public void run() { myt2.test3();   }  }, "test2"  );
//        test1.start();;
//        test2.start();

        //---------------------------------------------------------------------------------------
        //类锁修饰方法和代码块的效果和对象锁是一样的，因为静态方法是所有对象实例共用的，所以对应着synchronized修饰的静态方法的锁也是唯一的
//        final TestSynchronized myt2 = new TestSynchronized();
//        Thread test1 = new Thread(  new Runnable() {  public void run() {  myt2.test4();  }  }, "test1"  );
//        Thread test2 = new Thread(  new Runnable() {  public void run() { TestSynchronized.test5();   }  }, "test2"  );
//        test1.start();
//        test2.start();

        //---------------------------------------------------------------------------------------
        //synchronized同时修饰静态方法和实例方法，运行结果是交替进行的,线程获得对象锁的同时，也可以获得该类锁
        final TestSynchronized myt2 = new TestSynchronized();
        Thread test2 = new Thread(  new Runnable() {  public void run() {  myt2.test2();  }  }, "test2"  );
        Thread test6 = new Thread(  new Runnable() {  public void run() { TestSynchronized.test6();   }  }, "test6"  );
        test2.start();
        test6.start();

    }
}
