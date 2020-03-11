package com.interview.javabasic.classloader;

import com.interview.javabasic.reflect.Robot;

public class ClassLoaderDifference {
    public static void main(String[] args) {
        /**
         * 类装载的过程
         * 1.加载 通过ClassLoader加载.class文件字节码，生成Class对象
         *
         * 2.链接 校验 - 检查加载的class文件的正确性和安全性
         *        准备 - 为类变量分配存储空间并设置类变量的初始值
         *        解析 - JVM将常量池内的符号引用转换为直接引用
         *
         * 3.初始化 执行类变量赋值和静态代码块
         */

        //方式一： 验证ClassLoader类装载    静态代码块未执行
        // 由于ClassLoader中的loadClass()方法的重载的loadClass()方法中resolve为false 所以classLoader未进行类装载的第二步链接
        ClassLoader classLoader = Robot.class.getClassLoader();

        //方式二：验证Class.forName类装载   静态代码块已执行  所以Class.forName已经执行了类装载的第三步
        try {
            Class<?> forName = Class.forName("com.interview.javabasic.reflect.Robot");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
