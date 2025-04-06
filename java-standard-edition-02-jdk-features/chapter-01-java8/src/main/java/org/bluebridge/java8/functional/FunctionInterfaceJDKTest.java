package org.bluebridge.java8.functional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.function.*;

/**
 * JDK中内置的函数式接口测试
 */
public class FunctionInterfaceJDKTest {

    /**
     * 测试Runnable函数式接口
     */
    @Test
    public void testRunnable() {
        Runnable runnable = () -> System.out.println("Hello World");
        new Thread(runnable).start();
    }


    /**
     * 测试Callable函数式接口
     */
    @Test
    public void testCallable() throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> "Hello World";
        FutureTask<String> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        System.out.println("futureTask.get() = " + futureTask.get());
    }


    /**
     * 测试Comparator函数式接口
     */
    @Test
    public void testComparator() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("a",10));
        personList.add(new Person("c",10));
        personList.add(new Person("b",10));
        personList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println("personList = " + personList);
    }


    /**
     * 测试Consumer函数式接口
     */
    @Test
    public void testConsumer() {
        Consumer<Integer> consumer = i -> System.out.println(i.getClass());
        consumer.accept(1);
    }


    /**
     * 测试BiConsumer函数式接口
     */
    @Test
    public void testBiConsumer() {
        BiConsumer<String,String> biConsumer = (a,b) -> System.out.println(a+b);
        biConsumer.accept("a","b");
    }


    /**
     * 测试IntConsumer函数式接口
     */
    @Test
    public void testIntConsumer() {
        IntConsumer intConsumer = i -> System.out.println(i + i);
        intConsumer.accept(10);
    }


    /**
     * 测试LongConsumer函数式接口
     */
    @Test
    public void testLongConsumer() {
        LongConsumer longConsumer = i -> System.out.println(i + i);
        longConsumer.accept(20);
    }


    /**
     * 测试DoubleConsumer函数式接口
     */
    @Test
    public void testDoubleConsumer() {
        DoubleConsumer doubleConsumer = i -> System.out.println(i + i);
        doubleConsumer.accept(30);
    }


    /**
     * 测试Function函数式接口
     */
    @Test
    public void testFunction() {
        Person person = new Person("张三",25);
        Function<Person,String> functionString = p -> p.getName();
        System.out.println("姓名 = " + functionString.apply(person));

        Function<Person,Integer> functionInteger = p -> p.getAge();
        System.out.println("年龄 = " + functionInteger.apply(person));
    }


    /**
     * 测试BiFunction函数式接口
     */
    @Test
    public void testBiFunction() {
        BiFunction<String, Integer, Person> biFunction = (name, age) -> new Person(name,age);
        Person person = biFunction.apply("李四", 26);
        System.out.println("person = " + person);
    }


    /**
     * 测试IntFunction函数式接口
     */
    @Test
    public void testIntFunction() {
        IntFunction<Integer> intFunction = i -> i + i;
        System.out.println("intFunction.apply(10) = " + intFunction.apply(10));
    }


    /**
     * 测试LongFunction函数式接口
     */
    @Test
    public void testLongFunction() {
        LongFunction<Long> longFunction = l -> l + l;
        System.out.println("longFunction.apply(20) = " + longFunction.apply(20));
    }


    /**
     * 测试DoubleFunction函数式接口
     */
    @Test
    public void testDoubleFunction() {
        DoubleFunction<Double> doubleFunction = d -> d + d;
        System.out.println("doubleFunction = " + doubleFunction.apply(30));
    }


    /**
     * 测试Predicate函数式接口
     */
    @Test
    public void testPredicate() {
        Predicate<Integer> predicate = i -> i % 2 == 0;
        System.out.println("predicate.test(10) = " + predicate.test(10));
    }


    /**
     * 测试BiPredicate函数式接口
     */
    @Test
    public void testBiPredicate() {
        BiPredicate<String, String> biPredicate = (a, b) -> a.equals(b);
        System.out.println(biPredicate.test("a", "b"));
    }


    /**
     * 测试IntPredicate函数式接口
     */
    @Test
    public void testIntPredicate() {
        IntPredicate intPredicate1 = i -> (i - 5) >= 0;
        System.out.println("intPredicate1.test(5) = " + intPredicate1.test(5));
        System.out.println("intPredicate1.negate().test(5) = " + intPredicate1.negate().test(5));

        IntPredicate intPredicate2 = i -> i % 2 == 0;
        IntPredicate and = intPredicate1.and(intPredicate2);
        System.out.println("and.test(5) = " + and.test(5));
        System.out.println("and.test(6) = " + and.test(6));

        IntPredicate or = intPredicate1.or(intPredicate2);
        System.out.println("or.test(4) = " + or.test(4));
        System.out.println("or.test(3) = " + or.test(3));
    }


    /**
     * 测试LongPredicate函数式接口
     */
    @Test
    public void testLongPredicate() {
        LongPredicate longPredicate = i -> i % 2 == 0;
        System.out.println(longPredicate.test(10));
    }


    /**
     * 测试DoublePredicate函数式接口
     */
    @Test
    public void testDoublePredicate() {
        DoublePredicate doublePredicate = i -> i % 2 == 0;
        System.out.println(doublePredicate.test(10));
    }


    /**
     * 测试Supplier函数式接口
     */
    @Test
    public void testSupplier() {
        Supplier<Integer> supplier = () -> 10;
        System.out.println("supplier.get() = " + supplier.get());
    }


    /**
     * 测试IntSupplier函数式接口
     */
    @Test
    public void testIntSupplier() {
        IntSupplier intSupplier = () -> 10;
        System.out.println("intSupplier.getAsInt() = " + intSupplier.getAsInt());
    }


    /**
     * 测试LongSupplier函数式接口
     */
    @Test
    public void testLongSupplier() {
        LongSupplier longSupplier = () -> 10;
        System.out.println("longSupplier.getAsLong() = " + longSupplier.getAsLong());
    }


    /**
     * 测试DoubleSupplier函数式接口
     */
    @Test
    public void testDoubleSupplier() {
        DoubleSupplier doubleSupplier = () -> 10;
        System.out.println("doubleSupplier.getAsDouble() = " + doubleSupplier.getAsDouble());
    }


    /**
     * 测试UnaryOperator函数式接口
     */
    @Test
    public void testUnaryOperator() {
        UnaryOperator<Integer> unaryOperator = i -> i * 2;
        System.out.println("unaryOperator.apply(10) = " + unaryOperator.apply(10));
    }


    /**
     * 测试BinaryOperator函数式接口
     */
    @Test
    public void testBinaryOperator() {
        BinaryOperator<Integer> binaryOperator = (a, b) -> a + b;
        System.out.println("binaryOperator.apply(10,20) = " + binaryOperator.apply(10, 20));
    }


    /**
     * 测试BinaryOperator函数式接口
     */
    @Test
    public void testIntOperator() {
        IntUnaryOperator intUnaryOperator = a -> a * 2;
        System.out.println("intUnaryOperator.applyAsInt(10) = " + intUnaryOperator.applyAsInt(10));
    }


    /**
     * 测试IntBinaryOperator函数式接口
     */
    @Test
    public void testIntBinaryOperator() {
        IntBinaryOperator intBinaryOperator = (a, b) -> a + b;
        System.out.println("intBinaryOperator.applyAsInt(10,20) = " + intBinaryOperator.applyAsInt(10, 20));
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Person {
        private String name;
        private int age;
    }
}
