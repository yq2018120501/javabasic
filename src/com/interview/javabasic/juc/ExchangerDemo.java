package com.interview.javabasic.juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchanger交换器相关demo
 */
public class ExchangerDemo {
    static Exchanger exchanger = new Exchanger();
    public static void main(String[] args) {
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(()->{
            try {
                String gril = (String) exchanger.exchange("我其实暗恋你很久了。。。");
                System.out.println("女生说: " + gril);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(()->{
            try {
                System.out.println("女生慢慢的从教室走出来。。。");
                String boy = (String) exchanger.exchange("我很喜欢你。。。");
                System.out.println("男生说: " + boy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //关闭线程池
        executorService.shutdown();
    }
}
