package stream;
import	java.io.PrintStream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ronin
 */
public class StreamTest1 {
    public static void main(String[] args) {
        /**
         * 创建流的三种方式
         */
        //List<String> list = Arrays.asList("a", "b", "c");
        String[] arr = {"a", "b", "c"};
        List<String> list = Arrays.asList(arr);
        Stream<String> stream1 = list.stream();
        Stream<List<String>> stream2 = Stream.of(list);
        Stream<String> stream3 = Arrays.stream(arr);

        IntStream intStream = IntStream.of(new int[]{1, 2, 3,4,5,6});
        intStream.forEach(System.out::println);
        //3-8,不包含8
        IntStream.range(3,8).forEach(System.out::println);
        //3-8,包含8
        IntStream.rangeClosed(3,8).forEach(System.out::println);

        List<Integer> integers = Arrays.asList(1, 2, 3, 5);
        //等价于: 1+2+3+5+identity
        System.out.println(integers.stream().map(i -> i * 2).reduce(2, Integer::sum));

        /**
         * 将流转换为数组或者集合
         */
        Stream<String> streamToArray = Stream.of("hello", "world", "stream");
        //String[] lambdas = streamToArray.toArray(length -> new String[length]);
        //lambda表达式写法
        //Arrays.asList(lambdas).forEach(item -> System.out.println(item));
        //方法引用写法
        //String[] functionreference = streamToArray.toArray(String[]::new);
        //Arrays.asList(functionreference).forEach(item -> System.out.println(item));

        Stream<String> streamToList = Stream.of("hello", "world", "stream");
        //List<String> collect = streamToList.collect(Collectors.toList());
        //lambda表达式形式调用collect()
//        List<String> collect = streamToList.collect(()->new ArrayList(),(theList,item)->theList.add(item),
//                (theList1,theList12) -> theList1.addAll(theList12));

        Stream<String> streamToCllections = Stream.of("hello", "world", "stream");
        //方法引用形式调用collect()
        List<String> collect = streamToCllections.collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
        collect.forEach(item -> System.out.println(item));

        //将流转换为Collection(集合)的子类:方法引用形式调用toCollect()
        List<Integer> toCollection = Arrays.asList(8, 2, 3, 5);
        ArrayList<Integer> collect1 = toCollection.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect1);

        //将流转换为字符串:joining()
        Stream<String> joinngsource = Stream.of("hello", "world", "stream");
        String s = joinngsource.collect(Collectors.joining(",")).toString();
        System.out.println(s);

        System.out.println("----------------------------------------");
        /**
         * 把list中每个元素转为大写形式
         */
        List<String> toUppercase = Arrays.asList("a", "c", "d").stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(toUppercase);

        System.out.println("----------------------------------------");
        /**
         * flatMap():合并元数据
         */
        Stream<List<String>> listStream = Stream.of(Arrays.asList("a"), Arrays.asList("b", "c"), Arrays.asList("d", "e", "f"));
        listStream.flatMap(theList ->theList.stream()).map(String::toUpperCase).forEach(System.out::println);

        System.out.println("----------------------------------------");
        /**
         * generate()
         */
        Stream<String> generate = Stream.generate(UUID.randomUUID()::toString);
        Optional<String> first = generate.findFirst();
        first.ifPresent(System.out::println);

        //下面这句会不停的执行
        //Stream.iterate(1,i->i+2).forEach(System.out::println);
        //执行两次就结束了,limit(2):取前两个数据
        Stream.iterate(1,i->i+2).limit(2).forEach(System.out::println);

        System.out.println("----------------------------------------");
        /**
         * filter()
         */
        List<Integer> filter = Arrays.asList(1, 2, 3, 4, 5, 6);
        filter.stream().filter(item -> item>2).forEach(System.out::println);

        System.out.println("----------------------------------------");
        /**
         * sum()
         */
        List<Integer> sum = Arrays.asList(1, 2, 3, 4);
        System.out.println(sum.stream().mapToInt(item -> item).sum());

        System.out.println("----------------------------------------");
        /**
         * max()
         */
        List<Integer> max = Arrays.asList(1, 2, 3, 4);
        sum.stream().mapToInt(item -> item).max().ifPresent(System.out::println);

        System.out.println("----------------------------------------");
        /**
         * min()
         */
        List<Integer> min = Arrays.asList(1, 2, 3, 4);
        sum.stream().mapToInt(item -> item).min().ifPresent(System.out::println);

        System.out.println("----------------------------------------");
        /**
         * skip()
         */
        List<Integer> skip = Arrays.asList(1, 2, 3, 4);
        sum.stream().skip(2).forEach(System.out::println);
    }
}
