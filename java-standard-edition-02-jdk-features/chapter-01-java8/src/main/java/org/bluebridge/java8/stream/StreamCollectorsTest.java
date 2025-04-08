package org.bluebridge.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 收集流中元素到各种集合中
 */
public class StreamCollectorsTest {
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
     * 收集流中元素到List集合中
     */
    @Test
    public void testCollectToList(){
        //创建流
        Stream<Employee> stream = employees.stream();
        List<Employee> collectList = stream.filter(employee -> employee.getAge() > 15).collect(Collectors.toList());
        System.out.println(collectList);
    }

    /**
     * 收集流中元素到Set集合中
     */
    @Test
    public void testCollectToSet(){
        //创建流
        Stream<Employee> stream = employees.stream();
        Set<Employee> collectSet = stream.filter(employee -> employee.getAge() > 15).collect(Collectors.toSet());
        System.out.println(collectSet);
    }
}
