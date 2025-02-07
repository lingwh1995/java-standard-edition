package org.bluebridge.java8.test;

import org.bluebridge.java8.stream.Person;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 1.串行流和并行流
 * 2.流操作具有短路的特性
 * @author ronin
 */
public class StreamTest2 {
    public static void main(String[] args) {
        /**
         * 穿行流和并行流执行效率比较
         */
        //compare();
        /**
         * 分别使用串行和并行的方式查找出第一个长度为5的单词
         */
        //findStr();
        /**
         * 去重
         */
        //distinct();
        /**
         * flatMap()和map()的区别
         */
        //flatMapAndMap();
        /**
         * 分区
         */
        groupbyUserName();
        /**
         * 分组
         */
        partitioningByAe();
    }

    /**
     * 根据姓名进行分组
     */
    private static void groupbyUserName() {
        Person zs = new Person("zs", 10);
        Person ls = new Person("ls", 28);
        Person ww = new Person("ww", 38);
        Person zs1 = new Person("zs", 20);
        List<Person> people = Arrays.asList(zs, ls, ww, zs1);
        Map<String, List<Person>> collect = people.stream().collect(Collectors.groupingBy(Person::getUsername));
        collect.entrySet().forEach(entry-> System.out.println(entry.getKey()+"--"+entry.getValue()));
        //select name,count(*) from user group by name;
        System.out.println("----------------------------------");
        Map<String, Long> collect1 = people.stream().collect(Collectors.groupingBy(Person::getUsername, Collectors.counting()));
        collect1.entrySet().forEach(entry-> System.out.println(entry.getKey()+"--"+entry.getValue()));
        System.out.println("----------------------------------");
        //先分组再求平均值
        Map<String, Double> collect2 = people.stream().collect(Collectors.groupingBy(Person::getUsername, Collectors.averagingInt(Person::getAge)));
        collect2.entrySet().forEach(entry-> System.out.println(entry.getKey()+"--"+entry.getValue()));
    }

    /**
     * 根据年龄进行分区
     *      分为大于等于20的和不满足这个条件的
     */
    private static void partitioningByAe() {
        Person zs = new Person("zs", 10);
        Person ls = new Person("ls", 28);
        Person ww = new Person("ww", 38);
        Person zs1 = new Person("zs", 20);
        List<Person> people = Arrays.asList(zs, ls, ww, zs1);
        Map<Boolean, List<Person>> collect = people.stream().collect(Collectors.partitioningBy(person -> person.getAge() >= 20));
        collect.entrySet().forEach(entry-> System.out.println(entry.getKey()+"--"+entry.getValue()));
    }

    /**
     * flatMap()和map()的区别
     */
    private static void flatMapAndMap() {
        List<String> e1 = Arrays.asList("hi", "hello");
        List<String> e2 = Arrays.asList("zs", "ls","ww");
        e1.stream().flatMap(item1 ->e2.stream().map(item2 ->item1+","+item2)).collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * 去重:输出hello world stream
     */
    private static void distinct() {
        List<String> elements = Arrays.asList("hello", "hello world", "hello world stream");
        elements.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct()
                .forEach(System.out::println);
    }

    /**
     * 分别使用串行和并行的方式查找出第一个长度为5的单词
     */
    private static void findStr() {
        //串行
        List<String> sequential = Arrays.asList("hello", "world", "hello stream!");
        sequential.stream().mapToInt(item -> {
            System.out.println(item);
            return item.length();
        }).filter(length -> length == 5).findFirst().ifPresent(System.out::println);
        System.out.println("----------------------------------");
        //并行
        List<String> parallelism = Arrays.asList("hello", "world", "hello stream!");
        parallelism.stream().mapToInt(item -> {
            System.out.println(item);
            return item.length();
        }).filter(length -> length == 5).findFirst().ifPresent(System.out::println);
    }

    /**
     * 穿行流和并行流执行效率比较
     */
    private static void compare() {
        /**
         * 串行流排序:
         *      内部只有一个线程
         */
        int size = 500_0000;
        Random random = new Random();
        List<Integer> elements = new ArrayList<>(size);
        for(int i=0; i<size; i++){
            elements.add(random.nextInt(size));
        }
        long start1 = System.nanoTime();
        elements.stream().sorted().count();
        long end1 = System.nanoTime();
        System.out.println("串行流排序花费了:"+ TimeUnit.NANOSECONDS.toMillis(end1-start1)+"毫秒......");

        //清空集合
        elements.clear();
        //给集合重新添加元素
        for(int i=0; i<size; i++){
            elements.add(random.nextInt(size));
        }

        System.out.println("----------------------------");
        /**
         * 并行流排序:充分发挥多核CPU优势
         *      内部有多个线程
         */
        long start2 = System.nanoTime();
        elements.parallelStream().sorted().count();
        long end2 = System.nanoTime();
        System.out.println("并行流排序花费了:"+TimeUnit.NANOSECONDS.toMillis(end2-start2)+"毫秒......");
    }
}
