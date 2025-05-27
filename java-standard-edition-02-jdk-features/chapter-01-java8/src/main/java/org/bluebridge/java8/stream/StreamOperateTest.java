package org.bluebridge.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream流中间操作
 */
public class StreamOperateTest {
    private List<Employee> employees;

    /**
     * 初始化集合
     */
    @Before
    public void before() {
        Supplier<List<Employee>> supplier =  ArrayList :: new;
        List<Employee> employees = supplier.get();
        employees.add(new Employee(1l, "张三", 10, new BigDecimal(1000.5)));
        employees.add(new Employee(2l, "李四四",20, new BigDecimal(1500.5)));
        employees.add(new Employee(3l, "王五", 15, new BigDecimal(2000.5)));
        employees.add(new Employee(4l, "赵六", 25, new BigDecimal(2500.5)));
        employees.add(new Employee(5l, "赵六", 25, new BigDecimal(2500.5)));
        this.employees = employees;
    }

    /**
     * 遍历流中元素
     */
    @Test
    public void testStreamForeach() {
        //创建流
        Stream<Employee> stream = employees.stream();
        //遍历集合
        stream.forEach(System.out::println);
    }

    /**
     * 过滤流中元素
     *      过滤出年龄大于20的雇员
     */
    @Test
    public void testStreamFilter() {
        //创建流
        Stream<Employee> stream = employees.stream();
        //过滤流中元素
       stream.filter(e -> e.getAge() > 20).forEach(System.out::println);
    }

    /**
     * 截断流中元素
     *      找出前两个雇员
     */
    @Test
    public void testStreamLimit() {
        //创建流
        Stream<Employee> stream = employees.stream();
        //截断流
        stream.limit(2).forEach(System.out::println);
    }

    /**
     * 跳过前面n个元素
     */
    @Test
    public void testStreamSkip() {
        //创建流
        Stream<Employee> stream = employees.stream();
        //跳过前面元素
        stream.skip(2).forEach(System.out::println);
    }

    /**
     * 去重
     */
    @Test
    public void testStreamDistinct1() {
        //创建流
        Stream<Employee> stream = employees.stream();
        //去重
        stream.distinct().forEach(System.out::println);
    }

    /**
     * 去重
     */
    @Test
    public void testStreamDistinct2() {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 4, 5, 6);
        list.stream().distinct().forEach(System.out::println);
    }

    /**
     * 映射
     */
    @Test
    public void testStreamMap() {
        //创建流
        Stream<Employee> stream = employees.stream();
        //映射
        //stream.map(e -> e.getName()).forEach(System.out::println);
        stream.map(Employee :: getName).filter(name -> name.length() > 2).forEach(System.out::println);

        List<String> list = Arrays.asList("apple", "banana", "cherry");
        //list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
        list.stream().map(String :: toUpperCase).forEach(System.out::println);
    }

    /**
     * stream()常用统计方法
     */
    @Test
    public void testStreamMapToInt() {
        //sum()
        List<String> nums = Arrays.asList("1", "2", "3", "4");
        System.out.println(nums.stream().mapToInt(item -> Integer.parseInt(item)).sum());
        System.out.println("----------------------------------------");

        //max()
        nums = Arrays.asList("1", "2", "3", "4");
        nums.stream().mapToInt(item -> Integer.parseInt(item)).max().ifPresent(System.out::println);
        System.out.println("----------------------------------------");

        //min()
        nums = Arrays.asList("1", "2", "3", "4");
        nums.stream().mapToInt(item -> Integer.parseInt(item)).min().ifPresent(System.out::println);
        System.out.println("----------------------------------------");

        //count()
        nums = Arrays.asList("1", "2", "3", "4");
        long count = nums.stream().count();
        System.out.println("count = " + count);
        System.out.println("----------------------------------------");
    }

    /**
     * FlatMap： 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     *          嵌套列表的扁平化
     */
    @Test
    public void testStreamFlatMap1() {
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("1"),
                Arrays.asList("2", "3"),
                Arrays.asList("4", "5", "6")
        );
        //lambda表达式写法
        List<String> collect = nestedList.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println(collect);

        //方法引用写法
        collect = nestedList.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void testStreamFlatMap2() {
        List<String> list1 = Arrays.asList("hi", "hello");
        List<String> list2 = Arrays.asList("zs", "ls","ww");
        list1.stream().flatMap(item1 -> list2.stream().map(item2 -> item1 + "," + item2)).collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * 去重:输出hello world stream
     */
    @Test
    public void testStreamFlatMap3() {
        List<String> list = Arrays.asList("hello", "hello world", "hello world stream");
        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct()
                .forEach(System.out::println);
    }

    /**
     * 排序
     */
    @Test
    public void testStreamSorted() {
        List<Integer> nums = Arrays.asList(1, 8, 2, 6, 7, 3);
        nums.stream().sorted().forEach(System.out::println);

        //创建流
        Stream<Employee> stream = employees.stream();
        stream.sorted((e1,e2) -> Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out::println);
    }

    /**
     * 根据firstName分组
     */
    @Test
    public void testStreamGroupByFirstName() {
        Person p1 = new Person("张", "三", 10);
        Person p2 = new Person("李", "四", 20);
        Person p3 = new Person("王", "五", 30);
        Person p4 = new Person("王", "铭", 40);
        List<Person> persons = Arrays.asList(p1, p2, p3, p4);

        //根据firstName值进行分组，firstName值相同的Person对象放入到map的一个Entry中
        Map<String, List<Person>> groupingByResult1 = persons.stream().collect(Collectors.groupingBy(Person::getFirstName));
        groupingByResult1.entrySet().forEach(entry-> System.out.println(entry.getKey() + " -- " + entry.getValue()));
        //select name,count(*) from user group by name;
        System.out.println("----------------------------------");

        //根据firstName值进行分组，统计firstName值相同的Person对象的个数放入到一个Entry中
        Map<String, Long> groupingByResult2 = persons.stream().collect(Collectors.groupingBy(Person::getFirstName, Collectors.counting()));
        groupingByResult2.entrySet().forEach(entry-> System.out.println(entry.getKey() + " -- " + entry.getValue()));
        System.out.println("----------------------------------");

        //先分组再求平均值
        Map<String, Double> groupingByResult3 = persons.stream().collect(Collectors.groupingBy(Person::getFirstName, Collectors.averagingInt(Person::getAge)));
        groupingByResult3.entrySet().forEach(entry-> System.out.println(entry.getKey() + " -- " + entry.getValue()));
    }

    /**
     * 根据age进行分区
     *      根据指定的布尔条件将流中的元素分区到一个Map中，键为true和false。
     */
    @Test
    public void testStreamPartitioningByFirstName() {
        Person p1 = new Person("张", "三", 10);
        Person p2 = new Person("李", "四", 20);
        Person p3 = new Person("王", "五", 30);
        Person p4 = new Person("王", "铭", 40);
        List<Person> persons = Arrays.asList(p1, p2, p3, p4);
        Map<Boolean, List<Person>> partitionMap = persons.stream().collect(Collectors.partitioningBy(p -> p.getAge() > 20));
        System.out.println(partitionMap);
    }

    /**
     * 根据年龄进行分区
     *      分为大于等于20的和不满足这个条件的
     */
    @Test
    public void testStreamPartitioningByAge() {
        Person p1 = new Person("张","三", 10);
        Person p2 = new Person("李","四", 20);
        Person p3 = new Person("王","五", 30);
        Person p4 = new Person("王","铭", 40);
        List<Person> persons = Arrays.asList(p1, p2, p3, p4);
        Map<Boolean, List<Person>> collect = persons.stream().collect(Collectors.partitioningBy(person -> person.getAge() >= 20));
        collect.entrySet().forEach(entry-> System.out.println(entry.getKey() + " -- " + entry.getValue()));
    }


    /**
     * 分别使用串行和并行的方式查找出第一个长度为5的单词
     */
    @Test
    public void testStreamFindStr() {
        //串行
        List<String> source = Arrays.asList("hello", "world", "hello stream!");
        source.stream().filter(item -> item.length() == 5).findFirst().ifPresent(System.out::println);
        System.out.println("----------------------------------");

        //并行
        source.parallelStream().filter(item -> item.length() == 5).findFirst().ifPresent(System.out::println);
    }

    /**
     * 方法主要用于调试，它允许你在流的每个元素上执行某个操作（例如打印），而不会改变流中的元素。
     */
    @Test
    public void testStreamPeek() {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        List<String> result = list.stream()
                // 打印每个元素
                .peek(s -> System.out.println("Processing: " + s))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        // 输出: [APPLE, BANANA, CHERRY]
        System.out.println(result);
    }
}
