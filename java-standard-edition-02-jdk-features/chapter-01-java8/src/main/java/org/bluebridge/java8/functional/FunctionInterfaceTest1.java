package org.bluebridge.java8.functional;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 一些自定的函数式接口
 */
public class FunctionInterfaceTest1 {

    public static void main(String[] args) {
        Type1 type1 = a -> (a - 5) >= 0;
        System.out.println("type1 = " + type1.op(10));

        Type2 type2 = (a, b) -> a + b;
        System.out.println("type2 = " + type2.op(1,2));

        Type3 type3 = (a, b, c) -> a + b + c;
        System.out.println("type3 = " + type3.op(1,2,3));

        Type4 type4 = () -> new Student();
        System.out.println("type4 = " + type4.op());

        Type5 type5 = () -> {
            List<Student> students = new ArrayList<>();
            students.add(new Student());
            return students;
        };
        System.out.println("type5 = " + type5.op());

        Type6 type6_1 = () -> new String("hello lambda~");
        System.out.println("type6_1 = " + type6_1.op());

        Type6 type6_2 = () -> new Student();
        System.out.println("type6_2 = " + type6_2.op());

        Type7<String,Integer> type7_1 = s -> Integer.parseInt(s);
        System.out.println("type7_1 = " + type7_1.op("100"));

        Student student = new Student("张三",23);
        Type7<Student,String> type7_2 = stu -> stu.getName();
        System.out.println("姓名 = " + type7_2.op(student));

        Type7<Student,Integer> type7_3 = stu -> stu.getAge();
        System.out.println("年龄 = " + type7_3.op(student));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Student {
        private String name;
        private int age;
    }

    @FunctionalInterface
    interface Type1 {
        boolean op(int a);
    }

    @FunctionalInterface
    interface Type2 {
        int op(int a, int b);
    }

    @FunctionalInterface
    interface Type3 {
        int op(int a, int b, int c);
    }

    @FunctionalInterface
    interface Type4 {
        Student op();
    }

    @FunctionalInterface
    interface Type5 {
        List<Student> op();
    }

    /**
     * @param <T> 返回值类型
     */
    @FunctionalInterface
    interface Type6<T> {
        T op();
    }

    /**
     * @param <I> 输入类型
     * @param <O> 输出类型
     */
    @FunctionalInterface
    interface Type7<I,O> {
        O op(I i);
    }
}
