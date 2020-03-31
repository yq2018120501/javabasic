package com.interview.javabasic.test;

public class GuoLongTest {
    public static void main(String[] args) {
        /**
         * 成都国龙信息工程有限公司
         *
         * 1.dubbo与dubbox的区别
         *  Dubbo是阿里巴巴公司开源的一个基于Java的高性能开源RPC框架，使得应用可通过高性能的 RPC 实现服务的输出和输入功能，
         *  可以和 Spring框架无缝集成。后来因为某些原因没有维护，于是当当网在这之上推出了自己的Dubbox。
         *
         *  Dubbo支持多种协议，默认采用dubbo协议
         *  Dubbox采用rest协议，就是http+json的restful风格
         *
         *  Dubbo的项目结构是采用接口单独成一个项目，然后接口的实现就是生产者，接口的调用就是消费者
         *  Dubbox一般是不把接口单独成一个项目。直接用注解标识，实现完全解耦。消费者的只用声明接口，生产者实现接口也得加上相应的注解。
         *
         * 2.hashMap 1.7与1.8的区别
         *   JDK1.7采用数组+单链表的数据结构，单链表进行纵向延申，（采用头插法）当采用头插法时会容易出现逆序且环形链表死循环问题
         *   JDK1.8采用数组+链表+红黑树的数据结构，加入红黑树（尾插法），能够避免出现逆序且链表死循环的问题。
         *   （当链表的深度达到8的时候，也就是默认阈值，就会自动扩容把链表转成红黑树）
         *
         *   put()  -->  1.若HashMap未被初始化，则进行初始化操作
         *               2.对key求hash值，依据hash值计算下标
         *               3.若未发生hash碰撞，则直接放入桶中
         *               4.若发生碰撞，则以链表的方式链接到后面
         *               5.若链表(多个桶)长度超过阈值，且HashMap元素超过最低树化容量（MIN_TREEIFY_CAPACITY=64），则将链表转成红黑树
         *               6.若节点已经存在，则用新值替换旧值
         *               7.若桶满了（默认容量16*扩容因子0.75），就下需要resize（扩容2倍后重排）
         *
         *   HashMap扩容  -->
         *         多线程环境下，调整大小会存在条件竞争，容易造成死锁
         *         reHashing是一个比较耗时的过程
         *
         * 3.hashMap hash值相同如何处理
         *  hash碰撞 --> 上面第4步 以链表的方式链到后面（桶）
         *  如何减少碰撞？ -->  扰动函数
         *                    使用final对象并采用合适的equals()和hashCode()方法
         *
         * 4.redis 有哪些深入的了解，基本类型与分布式锁   什么情况下使用分布式锁？
         *   String  list  set  zset（有序集合）  hash
         *
         *   redis如何实现分布式锁 -->  1) setnx key value 如果key不存在，则创建并赋值
         *                               expire key 2  设置2秒的过期时间
         *                       伪代码：RedisService redisService = SpringUntils.getBean(RedisService.class);
         *                              long status = redisService.setnx(key,"value");
         *                              if(status == 1){
         *                                  redisService.expire(key,expire);
         *                                  //todo ....
         *                              }
         *                              当前分布式锁不是原子性的
         *                            2) set key value [ex s] [px m] [nx|xx]   set操作成功完成时，返回OK，否则返回nil
         *                      伪代码：RedisService redisService = SpringUntils.getBean(RedisService.class);
         *                             String res = redisService.set(key,"value",ex, expire,"nx");
         *                             if("OK".equals(res)){
         *                                  //todo ....
         *                             }
         *  大量的key同时过期问题(集中过期，由于清楚大量的key很耗时，会出现短暂的卡顿现象)  --> 在设置key过期时间的时候，给每个key加上随机值
         *
         * 5.死锁
         *   两个或两个以上的进程(线程)在执行过程种，因争夺资源而造成的一种互相等待现象，若无外力作用，它们将无法推进下去。
         *   （当线程A持有独占锁a，并尝试去获取独占锁b的同时，线程B持有独占锁b，并尝试获取独占锁a的情况下，就会发生AB两个线程由于互相持有对方需要的锁，而发生的阻塞现象，我们称为死锁）
         *
         *   如何避免？ -->  一个资源每次只能被一个线程使用
         *
         * 6.多线程实现方式
         *      继承Thread类  重写run()方法
         *      实现Runnable接口  重写run()方法
         *      实现Callable接口，有返回值 重写call()方法
         *      线程池创建线程 --> fix/cache/single/scheduled
         * 7.juc？？？
         *  juc包的分类 --> 线程执行器executor
         *                 锁locks   AQS
         *                 原子变量类atomic   CAS
         *                 并发工具类tools
         *                 并发集合collections
         *
         * 8.sql调优    exprier工具如何使用？
         *   1)创建索引 where 和 order by涉及到列上建立索引
         *   2)避免在索引上面使用计算
         *   3)where子句中顺序的调整
         *   4)尽量将多条sql压缩成一条sql 因为每次执行sql的时候建立链接、权限校验、sql语句查询优化、执行结构集，整个过程都非常耗时的
         *   5)where子句替换having子句  having只会检索出所有记录之后再进行过滤
         *   6)使用表的别名  在sql连接的多个表时，将表的别名前缀于每个列名上 ，可以减少解析时间
         *   7)select 语句尽量避免 '*'
         *     若某列没有值，为null。最好设置默认值，避免使用is null或 is not null
         *     like查询时，尽量避免前面使用'%'
         *     in关键字尽量避免使用，因为in是全表扫描
         *   8)数据量太大的话，也可以使用分表分库
         *
         * 9.单例创建  哪种情况使用double双重检查锁？
         *
         *
         * 10.springmvc是单例吗？
         *   默认 single
         *   实现多例 @Scope("prototype") 注解即可
         * 11.spring两个特别重要的beanFactory  factoryBean？
         * 12.shiro创建权限？   5张表
         * 13.springboot了解多少？
         *
         */
    }
}
