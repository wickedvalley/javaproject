package com.wickedvalley.datastructure.test;

/**
 * Created by MinZeng
 * 时间：2018/9/11.
 */
import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/8/8.
 * Barrier表示路障
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 10;
            }
        });

        new Thread(futureTask).start();

        System.out.println("获取的结果是："+futureTask.get());

        ExecutorService executorService=Executors.newCachedThreadPool();
        final CyclicBarrier cb =new CyclicBarrier(3);//需要3个线程同时到
        for(int i=0;i<3;i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println("线程"+Thread.currentThread().getName()+"即将到达集合点1，已有"+(cb.getNumberWaiting()+1)+"到达集合点");
                        cb.await();//三个线程都到了再继续执行下面的

                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println("线程"+Thread.currentThread().getName()+"即将到达集合点2，已有"+(cb.getNumberWaiting()+1)+"到达集合点");
                        cb.await();

                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println("线程"+Thread.currentThread().getName()+"即将到达集合点3，已有"+(cb.getNumberWaiting()+1)+"到达集合点");
                        cb.await();

                        System.out.println("集合完毕，大家开始吃饭了...");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            };
            executorService.submit(runnable);
        }
    }
}