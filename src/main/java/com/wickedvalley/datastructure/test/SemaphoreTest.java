package com.wickedvalley.datastructure.test;

/**
 * Created by MinZeng
 * 时间：2018/9/11.
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {

        ExecutorService threadPool=Executors.newCachedThreadPool();
        final Semaphore sp = new Semaphore(3);//信号量为3，表示可以访问的资源数为3
        for(int i=0;i<10;i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        sp.acquire();//能够获得资源
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程"+Thread.currentThread().getName()+"进入，当前已经有"+(3-sp.availablePermits())+"进入");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程"+Thread.currentThread().getName()+"即将离开");
                    sp.release();//释放资源
                    System.out.println("线程"+Thread.currentThread().getName()+"已经离开，当前已经有"+(3-sp.availablePermits()));
                }
            };
            threadPool.submit(runnable);
        }

    }
}