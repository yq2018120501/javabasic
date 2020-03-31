package com.interview.javabasic.test;

import java.util.HashMap;
import java.util.Hashtable;

public class ShuGuangTest {
    public static void main(String[] args) {
        //曙光国际---戴尔曼有限公司

        //1.
        /*
        int a=1,b=2;
        b=a++;
        System.out.println(b);  // 1     a++ = a  ++a = a + 1
        */
        //2.
        /*String a = "ABC";
        String b = "ABC";
        String c = new String("ABC");
        String d = new String("ABC");
        System.out.println(a==b);   //true
        System.out.println(b==c);   //false
        System.out.println(a==c);   //false
        */

        //3.
        /*byte a=10;
        byte b= 12;
        b = a+b;   //编译错误
        b += a;    //编译通过
        */

        //4.
        /*
        System.out.println(5/2);   // 2
        System.out.println(5%2);   // 1
        System.out.println(0/2);   // 0
        */

        //5.float f = 3.4;   //编译错误

        //6.HashMap、HashTable中key、value是否可以为空？
        //HashMap key、value都允行为null   HashTable key、value都不允行为null
        /*HashMap hashMap = new HashMap();
        hashMap.put(null,null);
        System.out.println(hashMap);
        Hashtable hashtable = new Hashtable();
        hashtable.put(null,null);  //运行异常
        System.out.println(hashtable);
        */
        //7.
        /*
        int a=1,b=2;
        for (int i = 0; i < 10; i++) {
            if (i%2==0)
                continue;
            a++;
        }
        System.out.println(a);  // 6
        for (int i = 0; i < 10; i++) {
            if (i%2==1)
                break;
            b++;
        }
        System.out.println(b); //3
        */
        //8.MyBatis中#和$哪一个防止注入？  #
        //9.是否可以从一个静态方法内部发出对非静态方法的调用？  //不能
        //10.
        /*
        final StringBuffer a= new StringBuffer("abc");
        a = new StringBuffer("");  //编译错误
        a.append("abc");  //编译通过
        */

        //11.Overloaded的方法是否可以改变返回值的类型？   //可以，因为重载和返回值无关
        // 重载（overload）:同一个类中，方法名相同，参数列表不同。与返回值类型无关。
        // 重写（override）:存在于子父类，或者子父接口中，方法声明相同。
        //  【重写的定义是方法名称相同，方法参数列表，返回值也要相同，只有继承了父类，子类才可以重写，但是字类的名称和父类的名称是不能一样的，从而构造函数的名称也是不一样的，所以就谈不上重写】
        //12.构造器是否可以被重写？
        //构造函数只能被重载，不能被重写

        //13.两个对象值相同（x.equals(y)==true）,但却可有不同的hashCode，这句话对不对？
        /*  https://blog.csdn.net/zouliping123456/article/details/82692127
        第一种情况回答：
        答：假如这个类没有重写equals方法，如果两个对象值相同(x.equals(y) == true)，那么那么它们的hashCode值一定要相同；
        第二种情况回答：
        答：但是如果重写equals方法，没有重写hashCode的方法，就会出现不相等的情况。
         */
        //14.
        /*
        int a = 1;
        for (int i = 0; i < 10; i++) {
            a=a++;
        }
        System.out.println(a);  // 1
        */

        //15.事务的ACID是指什么？
            //原子性、 隔离性、 一致性、持久性
        //16.sql关键字where是否可以包含聚合函数？having是否可以包含聚合函数？
            //where不可以包含聚合函数   having包含聚合函数
        //17.String,StringBuilder,StringBuffer运行速度关系？StringBuilder、StringBuffer哪个线程是安全的？
            //StringBuilder > StringBuffer > String    StringBuffer线程是安全的
        //18.SERVLET中FORWARD和REDIRECT发生几次请求？
            //FORWARD 发生1次请求 REDIRECT发生2次请求
        //19.前端与后端采用json格式进行数据交互，如何实现返回值类型为json对象？
            //使用注解@ResponseBody 或者 @RestController
        //20.session、cookie存储位置？
           // session存储在服务器端的，cookie存储在浏览器上的
        //21.创建一个线程常用的几种写法？举例说明
            //3种 实现Runnable接口、继承Thread类、实现Callable接口(有返回值的)
        //22.单例模式有几种写法？举例说明
            //2种 饿汉式、懒汉式
        //23.java有哪三大特性？举例说明
            //java语言特性 封装、继承、多态
        //24.访问修饰符public、protect、default、private的区别？
            //public修饰的 其同一项目其他包下都可以访问
            //protect修饰的 本类种
            //default修饰的 同包下
            //private修饰的 当前类
        //25.描述springmvc请求过程？
        /**
         * 1、用户发送请求至前端控制器DispatcherServlet。
         * 2、DispatcherServlet收到请求调用HandlerMapping处理器映射器。
         * 3、处理器映射器找到具体的处理器(可以根据xml配置、注解进行查找)，生成处理器对象及处理器拦截器(如果有则生成)一并返回给DispatcherServlet。
         * 4、DispatcherServlet调用HandlerAdapter处理器适配器。
         * 5、HandlerAdapter经过适配调用具体的处理器(Controller，也叫后端控制器)。
         * 6、Controller执行完成返回ModelAndView。
         * 7、HandlerAdapter将controller执行结果ModelAndView返回给DispatcherServlet。
         * 8、DispatcherServlet将ModelAndView传给ViewReslover视图解析器。
         * 9、ViewReslover解析后返回具体View.
         * 10、DispatcherServlet根据View进行渲染视图（即将模型数据填充至视图中）。 
         * 11、DispatcherServlet响应用户
         * 原文链接：https://blog.csdn.net/floating_dreaming/article/details/89089214
         */
    }
}
