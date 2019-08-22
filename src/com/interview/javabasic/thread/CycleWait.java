package com.interview.javabasic.thread;

public class CycleWait implements Runnable {
    private String value;
    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "we hava data now";
    }

    public static void main(String[] args) {
        CycleWait cw = new CycleWait();
        Thread t = new Thread(cw);
        t.start();
        //循环等待法
//        while (cw.value == null){
//            try {
//                Thread.currentThread().sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        //使用Thread类的join()方法
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("value: " + cw.value);
    }
}
