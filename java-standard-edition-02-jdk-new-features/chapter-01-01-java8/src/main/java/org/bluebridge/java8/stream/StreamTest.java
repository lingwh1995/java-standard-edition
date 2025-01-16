package org.bluebridge.java8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
	/**
	 *	通过集合创建	 			集合对象.stream()/集合对象.parallelStream()
	 *  通过数组创建   			Arrays.stream(数组)
	 *  通过可变参数创建			Stream.of(可变参数列表)
	 *  通过可变参数创建			Stream.of(可变参数列表)
	 *  构建一个不包容任何元素的流
	 *  通过方法创建
	 *  从文件中获得
	 */

	/**
	 * 创建Steam的六种方式：第一种	通过集合创建Stream
	 * 	.stream()			: 创建一个顺序执行的流
	 * 	.parallelStream()	: 创建一个并行执行的流
	 */
	@Test
	public void testCreateStreamByCollection() {
		/**
		 * 基于Set集合对象创建流
		 */
		Set<String> set = new HashSet<>();
		set.add("s1");
		set.add("s2");
		set.add("s3");
		// 基于集合对象创建流
		set.stream().forEach(s -> System.out.println(s));
		// 基于集合对象创建并行流
		set.parallelStream().forEach(s-> System.out.println(s));
		System.out.println("------------------01------------------");


		/**
		 * 基于List集合对象创建流
		 */
		List<String> list = new ArrayList<>();
		list.add("l1");
		list.add("l2");
		list.add("l3");
		// 基于集合对象创建流
		list.stream().forEach(s -> System.out.println(s));
		// 基于集合对象创建并行流
		list.parallelStream().forEach(s -> System.out.println(s));
		System.out.println("------------------02------------------");


		/**
		 * 基于Map集合对象创建流
		 */
		Map<String, String> map = new HashMap<>();
		map.put("k1","v1");
		map.put("k2","v2");
		map.put("k3","v3");
		//注意，map集合不能直接创建stream()，如果要创建stream，可以通过下面方式进行
			//方式一:	map.keySet().stream()
		map.keySet().stream().forEach(k -> System.out.println(k));
		//map.keySet().parallelStream().forEach(k -> System.out.println(k));
			//方式二:	map.values().stream()
		map.values().stream().forEach(v -> System.out.println(v));
		//map.values().parallelStream().forEach(v -> System.out.println(v));
			//方式三:	map.entrySet().stream()
		map.entrySet().stream().forEach(e -> System.out.println("key: " + e.getKey() + "," + "value: " + e.getValue()));
		//map.entrySet().parallelStream().forEach(e -> System.out.println("key: " + e.getKey() + "," + "value: " + e.getValue()));
		System.out.println("------------------03------------------");

		/**
		 * 基于TreeSet集合对象创建流
		 */
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("ts1");
		treeSet.add("ts2");
		treeSet.add("ts3");
		treeSet.stream().forEach(ts -> System.out.println(ts));
		treeSet.parallelStream().forEach(ts -> System.out.println(ts));
		System.out.println("------------------04------------------");
	}

	/**
	 * 创建Steam的六种方式：第二种	通过数组创建
	 * 	.stream()			: 创建一个顺序执行的流
	 * 	.parallelStream()	: 创建一个并行执行的流
	 */
	@Test
	public void testCreateStreamByArray() {
		//通过整型数组创建一个Stream对象
		IntStream intStream = Arrays.stream(new int[]{1, 2, 3});
		intStream.forEach(n -> System.out.println(n));

		//通过字符串数组创建一个Stream对象
		Stream<String> stream = Arrays.stream(new String[]{"a", "b", "c"});
		stream.forEach(s -> System.out.println(s));

		String[] names = {"Ken", "Jeff", "Chris", "Ellen"};
		Stream<String> namesStream = Arrays.stream(names);
		namesStream.forEach(name -> System.out.println(name));
	}

	/**
	 * 创建Steam的六种方式：第三种	通过可变参数创建
	 * 	.stream()			: 创建一个顺序执行的流
	 * 	.parallelStream()	: 创建一个并行执行的流
	 */
	@Test
	public void testCreateStreamByVariableArguments() {
		Stream<String> stream = Stream.of("a", "b", "c");
		stream.forEach(s -> System.out.println(s));
	}

	/**
	 * 创建Steam的六种方式：第四种	通过StreamBuilder创建
	 * 	.stream()			: 创建一个顺序执行的流
	 * 	.parallelStream()	: 创建一个并行执行的流
	 */
	@Test
	public void testCreateStreamByStreamBuilder() {
		Stream.Builder<String> builder = Stream.builder();
		Stream<String> build = builder.add("a")
									  .add("b")
									  .add("c")
									  .build();
		build.forEach(s -> System.out.println(s));
	}


	/**
	 * 创建Steam的六种方式：第五种	构建一个不包容任何元素的流
	 * 	.stream()			: 创建一个顺序执行的流
	 * 	.parallelStream()	: 创建一个并行执行的流
	 */
	@Test
	public void testCreateEmptyStream() {
		//构建一个空的字符串流
		Stream<String> stream = Stream.empty();
		//构建一个空的整数流
		IntStream numbers = IntStream.empty();
	}
}
