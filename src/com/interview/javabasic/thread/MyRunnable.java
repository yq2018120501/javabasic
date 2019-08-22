package com.interview.javabasic.thread;

public class MyRunnable implements Runnable {
    private String name;
    public MyRunnable() {

    }
    public MyRunnable(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread Start: " + this.name + ", i= " + i);
        }
    }

    public static void main(String[] args) {
        //构造函数传参
        MyRunnable mr1 = new MyRunnable("Runnable1");
        MyRunnable mr2 = new MyRunnable("Runnable2");
        MyRunnable mr3 = new MyRunnable("Runnable3");
        Thread t1 = new Thread(mr1);
        Thread t2 = new Thread(mr2);
        Thread t3 = new Thread(mr3);
//        t1.start();
//        t2.start();
//        t3.start();
        //set传参（成员变量传参）
        MyRunnable mr4 = new MyRunnable();
        MyRunnable mr5 = new MyRunnable();
        MyRunnable mr6 = new MyRunnable();
        mr4.setName("Runnable4");
        mr5.setName("Runnable5");
        mr6.setName("Runnable6");
        Thread t4 = new Thread(mr4);
        Thread t5 = new Thread(mr5);
        Thread t6 = new Thread(mr6);
        t4.start();
        t5.start();
        t6.start();
    }
}
