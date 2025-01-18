package org.bluebridge.java8.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.junit.Test;

/**
 * Java8函数式接口
 * 
 * 四个基本的函数式接口
 *    消费型接口	Consumer<T>				void accept(T t)
 * 	  供给型接口	Supplier<T>				T get()
 * 	  函数型接口	Function<T,R>			R apply(T t)
 * 	  断定型接口	Predicate<T>			boolean test(T t)
 * 
 * https://blog.csdn.net/qq_33591903/article/details/102948344
 */
public class Java8FunctionInterface {
	
	
	@Test
	public void testConsumer1() {
		//匿名内部类方式使用Consumer接口
		Consumer<Integer> consumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		};
		consumer.accept(1);
		
		
		//lambda方式使用Consumer接口
		consumer = t -> System.out.println(t);
		consumer.accept(10);
	}
	
	
	@Test
	public void testConsumer2() {
		//匿名内部类方式使用Consumer接口
		show(1,new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		});
		
		
		//lambda方式使用Consumer接口
		show(10,t -> System.out.println(t));
	}
	
	public void show(Integer i, Consumer<Integer> consumer) {
		consumer.accept(i);
	}
	
	
	@Test
	public void testConsumer3() {
		//使用Consumer类型对象作为forEach()参数
	    List<Integer> list = Arrays.asList(1,3,5,7,9);
	    Consumer<Integer> consumer = t -> System.out.println(t);
	    list.stream().forEach(consumer);
	    
	    
	    //使用Consumer类型对象作为forEach()参数
	    list = Arrays.asList(2,4,6,8,10);
	    list.stream().forEach(i -> System.out.println(i));
	}
	
	
	@Test
	public void testPredicate1() {
		//匿名内部类方式使用Predicate接口
		List<String> list = Arrays.asList("周杰伦","周冬雨","马冬梅");
		List<String> filterResult = filter(list, new Predicate<String>() {
			@Override
			public boolean test(String s) {
				return s.contains("周");
			}
		});
		System.out.println(filterResult);
		
		
		//lambda方式使用Predicate接口
		filterResult = filter(list, s -> s.contains("冬"));
		System.out.println(filterResult);
	}
	
	public List<String> filter(List<String> source, Predicate<String> predicate) {
		List<String> target = new ArrayList<>();
		source.forEach(s -> {
			if(predicate.test(s)) {
				target.add(s);
			}
		});
		return target;
	}
}
