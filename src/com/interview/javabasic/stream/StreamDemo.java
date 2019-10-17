package com.interview.javabasic.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * java8 Stream第一个Demo
 */
public class StreamDemo {
    public static void main(String[] args) {

        //集合接口有两个方法来生成流 stream()  parallelStream() -- 并行处理
        List<String> list = Arrays.asList("adc", "abd", "bcd", "", "edf");
        System.out.println(list.toString());
        List<String> stringList = list.parallelStream().filter(str -> !str.isEmpty()).collect(Collectors.toList());
        System.out.println(stringList.toString());

        //forEach   limit方法用于获取指定数量
        Random random = new Random();
        random.ints(0,10).limit(5).forEach(System.out::println);

        System.out.println("---------------------------------------------");

        //map方法用于映射每个元素到对应的结果
        List<Integer> integers = Arrays.asList(1, 3, 5, 2, 4, 5, 3);
        List<Integer> integerList = integers.stream().map(i -> i * i).collect(Collectors.toList());
        integerList.forEach(System.out::println);

        System.out.println("---------------------------------------------");

        //filfter方法用于通过设置的条件过滤出元素
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count = strings.stream().filter(s -> s.isEmpty()).count();
        System.out.println(count);

        System.out.println("---------------------------------------------");

        //sorted方法用于对流进行排序
        Random random1 = new Random();
        random1.ints(0,100).limit(10).sorted().forEach(System.out::println);

        System.out.println("---------------------------------------------");

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().mapToInt((x)->x).summaryStatistics();
    }
}
