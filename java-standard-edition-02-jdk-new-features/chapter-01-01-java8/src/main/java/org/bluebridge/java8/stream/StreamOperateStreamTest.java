package org.bluebridge.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream中间操作
 */
public class StreamOperateStreamTest {
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
    public void testStreamDistinct() {
        //创建流
        Stream<Employee> stream = employees.stream();
        //去重
        stream.distinct().forEach(System.out::println);
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

        List<String> list = Arrays.asList("a", "b", "c");
        //list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
        list.stream().map(String :: toUpperCase).forEach(System.out::println);
    }

    /**
     * FlatMap： 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     *          嵌套列表的扁平化
     */
    @Test
    public void testStreamFlatMap() {
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("1", "2", "3"),
                Arrays.asList("4", "4", "6"),
                Arrays.asList("7", "8", "9")
        );
        List<String> collect = nestedList.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println(collect);

        collect = nestedList.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(collect);
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
}
