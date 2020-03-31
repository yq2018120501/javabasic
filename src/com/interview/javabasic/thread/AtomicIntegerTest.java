package com.interview.javabasic.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    private static final int THREAD_COUNT = 10;
    public static AtomicInteger count = new AtomicInteger(0);

    private static void increase(){
        //count++;
        count.incrementAndGet();
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(count);
    }
}
