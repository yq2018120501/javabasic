package com.interview.javabasic.thread;

//演示编译后代码讲解
public class SyncBlockAndMethod {
    public void syncsTask (){
        //同步代码块
        synchronized (this){
            System.out.println("Hello");
        }
    }

    public synchronized void syncTask(){
        System.out.println("Hello again");
    }
}
