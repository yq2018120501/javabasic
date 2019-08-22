package com.interview.javabasic.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService newCacheThreadPool = Executors.newCachedThreadPool();
        Future<String> future = newCacheThreadPool.submit(new MyCallable());
        if (!future.isDone()){
            System.out.println("task has not finished, please wait!");
        }
        try {
            System.out.println("task return: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            newCacheThreadPool.shutdown();
        }
    }
}
