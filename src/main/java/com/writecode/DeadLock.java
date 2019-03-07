package com.writecode;


/**
 * Created by MinZeng
 * 时间：2019/3/4.
 *
 * 思路是创建两个字符串a和b，再创建两个线程A和B，让每个线程都用synchronized锁住字符串
 * （A先锁a，再去锁b；B先锁b，再锁a），如果A锁住a，B锁住b，A就没办法锁住b，B也没办法锁住a，这时就陷入了死锁
 *
 */
public class DeadLock {
    private static String obj1="obj1";
    private static String obj2="obj2";

    public static void main(String[] args) {

        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }

   static class Thread1 implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread1 is running ...");
            synchronized (obj1){
                System.out.println("Thread1 lock obj1");
                try {
                    Thread.sleep(3000);//获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2

                    synchronized(obj2){
                        System.out.println("Thread1 lock obj2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

   static class Thread2 implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread2 is running ...");
            synchronized (obj2){
                try {
                    System.out.println("Thread2 get obj2");
                    Thread.sleep(3000);
                    synchronized (obj1){
                        System.out.println("Thread2 get obj1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
