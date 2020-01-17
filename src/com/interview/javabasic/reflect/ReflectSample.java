package com.interview.javabasic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectSample {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> rc = Class.forName("com.interview.javabasic.reflect.Robot");
        Robot r = (Robot) rc.newInstance();
        System.out.println("Class name is " + rc.getName());

        //获取私有方法，不能获取继承的方法
        Method throwHello = rc.getDeclaredMethod("throwHello", String.class);
        throwHello.setAccessible(true);
        Object bob = throwHello.invoke(r, "Bob");
        System.out.println("throwHello result is " + bob);
        //获取public的方法
        Method sayHi = rc.getMethod("sayHi", String.class);
        sayHi.invoke(r,"welcome");
        //获取类的私有属性
        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(r,"Alice");
        sayHi.invoke(r,"welcome");
    }
}
