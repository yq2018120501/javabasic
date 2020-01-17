package com.interview.javabasic.classloader;

public class ClassLoaderMain {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String path = "C:\\Users\\21288\\Desktop\\";
        String classLoaderName = "custom";
        CustomClassLoader custom = new CustomClassLoader(path,classLoaderName);
        Class<?> wali = custom.loadClass("Wali");
        System.out.println(wali.getClassLoader());
        wali.newInstance();
    }
}
