package com.interview.javabasic.thread;

public class NotificationDemo {
    private volatile boolean go = false;

    public static void main(String[] args) throws InterruptedException {
        final NotificationDemo test = new NotificationDemo();

        Runnable waitTask = new Runnable() {
            @Override
            public void run() {
                try {
                    test.shouldGo();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finished Execution");
            }
        };
        Runnable notifyTask = new Runnable() {
            @Override
            public void run() {
                try {
                    test.go();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finished Execution");
            }
        };

        Thread t1 = new Thread(waitTask,"WT1");
        Thread t2 = new Thread(waitTask,"WT2");
        Thread t3 = new Thread(waitTask,"WT3");
        Thread t4 = new Thread(notifyTask,"NT1");
        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(200);

        t4.start();
    }

    private synchronized void shouldGo() throws InterruptedException{
        while (go != true){
            System.out.println(Thread.currentThread().getName() + " is going to wait on this Object");
            wait();
            System.out.println(Thread.currentThread().getName() + " is woken up");
        }
        go = false;
    }

    private synchronized void go() throws InterruptedException{
        while (go == false){
            System.out.println(Thread.currentThread().getName() + " is going to notify all or one thread waiting on this Object");
            go = true;
            notify();
        }
    }
}
