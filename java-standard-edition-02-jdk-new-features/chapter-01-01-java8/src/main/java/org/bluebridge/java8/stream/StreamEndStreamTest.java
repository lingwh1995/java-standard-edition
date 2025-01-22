package org.bluebridge.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Stream流中止操作
 */
public class StreamEndStreamTest {
    private List<Employee> employees;

    /**
     * 初始化集合
     */
    @Before
    public void before() {
        Supplier<List<Employee>> supplier =  ArrayList:: new;
        List<Employee> employees = supplier.get();
        employees.add(new Employee(1l, "张三", 10, new BigDecimal(1000.5)));
        employees.add(new Employee(2l, "李四四",20, new BigDecimal(1500.5)));
        employees.add(new Employee(3l, "王五", 15, new BigDecimal(2000.5)));
        employees.add(new Employee(4l, "赵六", 25, new BigDecimal(2500.5)));
        employees.add(new Employee(5l, "赵六", 25, new BigDecimal(2500.5)));
        this.employees = employees;
    }

    /**
     * 遍历流
     */
    @Test
    public void testStreamForeach() {
        //创建流
        Stream<Employee> stream = employees.stream();
        //stream.forEach(employee -> System.out.println(employee));
        stream.forEach(System.out :: println);
    }

    /**
     * 检查是否匹配所有元素
     */
    @Test
    public void testStreamAllMatch() {
        //创建流
        Stream<Employee> stream = employees.stream();
        boolean allMatch = stream.allMatch(employee -> employee.getAge() > 15);
        System.out.println(allMatch);
    }

    /**
     * 检查是否匹配至少一个元素
     */
    @Test
    public void testStreamAnyMatch() {
        //创建流
        Stream<Employee> stream = employees.stream();
        boolean anyMatch = stream.anyMatch(employee -> employee.getAge() > 15);
        System.out.println(anyMatch);
    }

    /**
     * 检查是否没有匹配的元素
     */
    @Test
    public void testStreamNoneMatch() {
        //创建流
        Stream<Employee> stream = employees.stream();
        boolean noneMatch = stream.noneMatch(employee -> employee.getAge() > 15);
        System.out.println(noneMatch);
    }

    /**
     * 返回当前流中第一个元素
     */
    @Test
    public void testStreamFindFirst() {
        //创建流
        Stream<Employee> stream = employees.stream();
        Optional<Employee> first = stream.findFirst();
        System.out.println(first.get());
    }

    /**
     * 返回当前流中任意元素
     */
    @Test
    public void testStreamFindAny() {
        //创建流
        Stream<Employee> stream = employees.stream();
        Optional<Employee> any = stream.findAny();
        System.out.println(any.get());
    }

    /**
     * 计算当前流中元素总个数
     */
    @Test
    public void testStreamCount() {
        //创建流
        Stream<Employee> stream = employees.stream();
        long count = stream.count();
        System.out.println(count);
    }

    /**
     * 获取计算当前流中值最大的元素
     */
    @Test
    public void testStreamMax() {
        //创建流
        Stream<Employee> stream = employees.stream();
        //Optional<Employee> maxEmployee = stream.max((e1, e2) -> Double.compare(e1.getSalary().doubleValue(), e2.getSalary().doubleValue()));
        Optional<Employee> maxEmployee = stream.max(Comparator.comparingDouble(e -> e.getSalary().doubleValue()));
        System.out.println(maxEmployee.get());

        Optional<Integer> maxInteger = Arrays.asList(1, 2, 3, 4, 5, 6).stream().max(Integer::compareTo);
        System.out.println(maxInteger.get());
    }

    /**
     * 获取计算当前流中值最小的元素
     */
    @Test
    public void testStreamMin() {
        //创建流
        Stream<Employee> stream = employees.stream();
        //Optional<Employee> minEmployee = stream.min((e1, e2) -> Double.compare(e1.getSalary().doubleValue(), e2.getSalary().doubleValue()));
        Optional<Employee> minEmployee = stream.min(Comparator.comparingDouble(e -> e.getSalary().doubleValue()));
        System.out.println(minEmployee.get());

        Optional<Integer> minInteger = Arrays.asList(1, 2, 3, 4, 5, 6).stream().min(Integer::compareTo);
        System.out.println(minInteger.get());
    }

    /**
     * 归并计算
     *      可以将流中的元素反复结合起来，得到一个值，然后返回
     */
    @Test
    public void testStreamReduce() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer result = nums.stream().reduce(0, Integer::sum);
        System.out.println(result);

        Optional<Integer> resultOptional = nums.stream().reduce(Integer::sum);
        System.out.println(resultOptional.get());
    }
}
