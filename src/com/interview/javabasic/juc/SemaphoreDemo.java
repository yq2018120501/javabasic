package com.interview.javabasic.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量 相关demo
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        //模拟20个客户端访问
        for (int i = 0; i < 20; i++) {
            final int NO = i;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取许可
                        semp.acquire();
                        System.out.println("Accessing: " + NO);
                        Thread.sleep((long) (Math.random()*10000));
                        //访问完后，释放
                        semp.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(run);
        }
        //退出线程池
        executorService.shutdown();
    }
}
