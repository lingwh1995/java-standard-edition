package org.bluebridge.java8.java8reference;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

import org.junit.Test;

/**
 * 1.方法引用简介
 * 		方法引用就是lambda表达式，也就是函数式接口的一个实例，通过方法的名字来指向一个方法，是lambda的一种语法糖，可以看做是lambda表达式深层次的表达。
 * 2.什么情况下可以使用方法引用
 * 		当要传递给lambda体的操作，已经有了实现方法了，可以使用方法引用
 * 3.方法引用的四种使用方式
 * 		情况一: 	静态方法引用 	 		类名 :: staticMethodName
 * 		情况二: 	实例方法引用
 * 				格式一	instanceReference :: instanceMethodName
 * 				格式二	类名 :: instanceMethodName
 * 		情况三: 	构造方法引用	 		类名 :: new
 * 		情况四: 	数组构造方法引用		数据类型[]::new
 * 5.方法引用参数问题
 * 		方法参数由编译器自动识别
 */
public class MethodReference {
	
	/**
	 * 情况一:	静态方法引用(类名 :: staticMethodName)
	 * 			案例一: Function<String,Integer> function = Integer :: parseInt
	 */
	@Test
	public void testStaticMethodReference1(){
		//匿名内部类
		Function<String,Integer> function = new Function<String,Integer>() {
			@Override
			public Integer apply(String t) {
				return Integer.parseInt(t);
			}
		};
		Integer apply = function.apply("10");
		System.out.println(apply.getClass().getSimpleName());
		System.out.println("------------------------------");

		//lambda表达式
		function = (t) -> Integer.parseInt(t);
		apply = function.apply("20");
		System.out.println(apply.getClass().getSimpleName());
		System.out.println("------------------------------");

		//方法引用
		function = Integer :: parseInt;
		int number = function.apply("30");
		System.out.println(number);
		System.out.println("------------------------------");
	}


	/**
	 * 情况一:	静态方法引用(类名 :: staticMethodName)
	 *  		案例二: MyClass :: printMessage
	 */
	@Test
	public void testStaticMethodReference2(){
		//匿名内部类
		Consumer<String> consumer = new Consumer<String>() {
			@Override
			public void accept(String s) {
				MyClass.printMessage(s);
			}
		};
		consumer.accept("10");
		System.out.println("------------------------------");

		//lambda表达式
		consumer = s -> MyClass.printMessage(s);
		consumer.accept("20");
		System.out.println("------------------------------");

		//方法引用
		consumer = MyClass :: printMessage;
		consumer.accept("30");
		System.out.println("------------------------------");
	}


	/**
	 * 情况一:	静态方法引用(类名 :: staticMethodName)
	 * 			案例三: Comparator<Integer> comparator = Integer :: compare;
	 */
	@Test
	public void testStaticMethodReference3() {
		//匿名内部类
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		};
		System.out.println(comparator.compare(10, 20));
		System.out.println("------------------------------");

		//lambda表达式
		comparator = (t1,t2) -> Integer.compare(t1, t2);
		System.out.println(comparator.compare(20, 10));
		System.out.println("------------------------------");

		//方法引用
		comparator = Integer :: compare;
		System.out.println(comparator.compare(10, 20));
		System.out.println("------------------------------");
	}


	/**
	 * 情况一:	静态方法引用(类名 :: staticMethodName)
	 * 			案例四: Function<Double, Long> function = Math :: round;
	 */
	@Test
	public void testStaticMethodReference4() {
		//匿名内部类
		Function<Double, Long> function = new Function<Double, Long>() {
			@Override
			public Long apply(Double d) {
				return Math.round(d);
			}
		};
		System.out.println(function.apply(12.3));
		System.out.println("------------------------------");

		//lambda表达式
		function = d -> Math.round(d);
		System.out.println(function.apply(15.6));
		System.out.println("------------------------------");

		//方法引用
		function = Math :: round;
		System.out.println(function.apply(18.3));
		System.out.println("------------------------------");
	}


	/**
	 * 情况一:	静态方法引用(类名 :: staticMethodName)
	 * 			案例五: Function<String, String> function = String :: toUpperCase;
	 */
	@Test
	public void testStaticMethodReference5() {
		//匿名内部类
		Function<String, String> function = new Function<String, String>() {
			@Override
			public String apply(String s) {
				return s.toUpperCase();
			}
		};
		System.out.println(function.apply("abc"));
		System.out.println("------------------------------");

		//lambda表达式
		function = s -> s.toUpperCase();
		System.out.println(function.apply("abc"));
		System.out.println("------------------------------");

		//方法引用
		function = String :: toUpperCase;
		System.out.println(function.apply("abc"));
		System.out.println("------------------------------");
	}


	/**
	 * 情况一:	静态方法引用(类名 :: staticMethodName)
	 * 			案例六: System.out::println
	 */
	@Test
	public void testStaticMethodReference6() {
		//lambda表达式
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        list.forEach(item -> System.out.println(item));
        System.out.println("------------------------------------");

		//方法引用
        list.forEach(System.out::println);
		System.out.println("------------------------------------");
	}


	/**
	 * 情况二: 	实例方法引用(instanceReference::instanceMethodName)
	 * 			案例一: String s = "method reference";
	 * 				   Supplier<Boolean> supplier = s :: isEmpty
	 */
	@Test
	public void testInstanceReference1(){
		String s = "method reference";
		//匿名内部类
		Supplier<Boolean> supplier = new Supplier<Boolean>() {
			@Override
			public Boolean get() {
				return s.isEmpty();
			}
		};
		System.out.println(supplier.get());
		System.out.println("------------------------------");

		//lambda表达式
		supplier = () -> s.isEmpty();
		System.out.println(supplier.get());
		System.out.println("------------------------------");

		//方法引用
		supplier = s :: isEmpty;
		System.out.println(supplier.get());
		System.out.println("------------------------------");
	}


	/**
	 * 情况二: 	实例方法引用(instanceReference::instanceMethodName)
	 * 			案例二: PrintStream ps = System.out;
	 * 				   Consumer<String> consumer = ps :: println;
	 */
	@Test
	public void testInstanceReference2() {
		//匿名内部类
		Consumer<String> consumer = new Consumer<String>() {
			@Override
			public void accept(String i) {
				System.out.println(i);
			}
		};
		consumer.accept("10");
		System.out.println("------------------------------");

		//lambda表达式
		consumer = i -> System.out.println(i);
		consumer.accept("20");
		System.out.println("------------------------------");

		//方法引用
		PrintStream ps = System.out;
		consumer = ps :: println;
		consumer.accept("30");
		System.out.println("------------------------------");
	}


	/**
	 * 情况二: 	实例方法引用(instanceReference::instanceMethodName)
	 * 			案例三: Person person = new Person("张三",23);
	 * 				   person :: getUsername;
	 */
	@Test
	public void testInstanceReference3() {
		Person person = new Person("张三",23);
		//匿名内部类
		Supplier<String> supplier = new Supplier<String>() {
			@Override
			public String get() {
				return person.getUsername();
			}
		};
		System.out.println(supplier.get());
		System.out.println("------------------------------");

		//lambda表达式
		supplier = () -> person.getUsername();
		System.out.println(supplier.get());
		System.out.println("------------------------------");

		//方法引用
		supplier = person :: getUsername;
		System.out.println(supplier.get());
		System.out.println("------------------------------");
	}


	/**
	 * 情况二: 	实例方法引用(instanceReference::instanceMethodName)
	 * 			案例四: Comparator<String> comparator = String :: compareTo;
	 */
	@Test
	public void testInstanceReference4() {
		//匿名内部类
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};

		//lambda
		comparator = (s1,s2) -> s1.compareTo(s2);
		System.out.println(comparator.compare("abc", "abd"));
		System.out.println("------------------------------");

		//方法引用
		comparator = String :: compareTo;
		System.out.println(comparator.compare("abc", "abc"));
		System.out.println("------------------------------");
	}


	/**
	 * 情况二: 	实例方法引用(instanceReference::instanceMethodName)
	 * 			案例五: Comparator<String> comparator = String :: compareTo;
	 */
	@Test
	public void testMethodReference5() {
		//匿名内部类
		BiPredicate<String, String> biPredicate = new BiPredicate<String,String>() {
			@Override
			public boolean test(String a, String b) {
				return a.equals(b);
			}
		};
		System.out.println(biPredicate.test("aaa", "aaa"));
		System.out.println("--------------------------------------");

		//lambda表达式
		biPredicate = (a,b) -> a.equals(b);
		System.out.println(biPredicate.test("bbb", "bbb"));
		System.out.println("--------------------------------------");

		//方法引用
		biPredicate = String :: equals;
		System.out.println(biPredicate.test("ccc", "ccc"));
		System.out.println("--------------------------------------");
	}

	/**
	 * 情况二: 	实例方法引用(类名::instanceMethodName)
	 * 			案例流: Function<Person, String> function = Person :: getUsername;
	 */
	@Test
	public void testMethodReference6() {
		Person person = new Person("张三",128);
		//匿名内部类
		Function<Person, String> function = new Function<Person,String>() {
			@Override
			public String apply(Person t) {
				return t.getUsername();
			}
		};
		System.out.println(function.apply(person));
		System.out.println("------------------------------");


		//lambda表达式
		function = p -> p.getUsername();
		System.out.println(function.apply(person));
		System.out.println("------------------------------");


		//方法引用
		function = Person :: getUsername;
		System.out.println(function.apply(person));
		System.out.println("------------------------------");
	}

	/**
	 * 情况三: 	构造方法引用(类名::new)
	 * 			案例一: ArrayList::new
	 */
	@Test
	public void testConstructorReference1(){
		Supplier<ArrayList<Integer>> supplier = ArrayList :: new;
		System.out.println(supplier.get());
	}


	/**
	 * 情况四: 	数组构造方法引用		数据类型[]::new
	 * 			案例一: 使用方法引用创建空的String类型数组
	 */
	@Test
	public void testArrayConstructorReference1(){
		//lambda表达式(初始化一个长度为10的String类型数组)
		Function<Integer,String[]> function = l ->new String[l];
		String[] apply = function.apply(10);
		System.out.println(apply);

		//数组构造引用(初始化一个长度为10的String类型数组)
		function = String[] :: new;
		apply = function.apply(10);
		System.out.println(apply);
	}


	/**
	 * 情况四: 	数组构造方法引用		数据类型[]::new
	 * 			案例二: 使用方法引用创建空的int类型数组
	 */
	@Test
	public void testArrayConstructorReference2(){
		//lambda表达式(初始化一个长度为10的int类型数组)
		Function<Integer, int[]> function = int[]::new;
		int[] apply = function.apply(10);
		System.out.println(Arrays.toString(apply));

		//数组构造引用(初始化一个长度为10的int类型数组)
		function = int[]::new;
		apply = function.apply(10);
		System.out.println(Arrays.toString(apply));
	}


	/**
	 * 情况四: 	数组构造方法引用		数据类型[]::new
	 */
	@Test
	public void testArrayConstructorReference3(){
		//1.创建集合并添加元素
		ArrayList<Integer> list = new ArrayList<>();
		Collections.addAll(list, 1, 2, 3, 4, 5);
		//2.收集到数组当中
		Integer[] nums = list.stream().toArray(new IntFunction<Integer[]>() {
			@Override
			public Integer[] apply(int value) {
				return new Integer[value];
			}
		});

		//方法引用
		Integer[] arr2 = list.stream()
				// 此时它会去创建一个Integer类型的数组，长度和流里面数组的个数是一样的，并把流里面的数据放到数组中
				.toArray(Integer[]::new);
		System.out.println(Arrays.toString(arr2));
	}

	//https://blog.csdn.net/a_beiyo/article/details/142216688
    public static void main(String[] args) {
//
//        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
//        list.forEach(item -> System.out.println(item));
//        System.out.println("------------------------------------");
//        list.forEach(System.out::println);
//
//        System.out.println("------------------------------------");
//        //排序
//        //lambda写法
//        ArrayList<Person> persons = new ArrayList<>();
//        persons.add(new Person("ls",28));
//        persons.add(new Person("zs",18));
//        persons.add(new Person("ww",48));
//        persons.add(new Person("ls",38));
//        //persons.sort((p1,p2) -> Person.compare(p1,p2));
//        persons.forEach(item -> System.out.println(item));
//        System.out.println("------------------------------------");
//        //方法引用写法
//        //persons.sort(PersonComparator::compareStatic);
//        persons.forEach(item -> System.out.println(item));
//
//        System.out.println("------------------------------------");
//        /**
//         * 2.实例方法引用:方法参数由编译器自动识别
//         *      注意:被引用的方法不能是静态的,会报错
//         */
//        PersonComparator personComparator = new PersonComparator();
//        //persons.sort((p1,p2) -> personComparator.compareNoStatic(p1,p2));
//        //persons.sort(personComparator::compareNoStatic);
//        persons.forEach(item -> System.out.println(item));
//        System.out.println("------------------------------------");
//
//        /**
//         * 3.类名::实例方法名
//         *      方法的调用者是lambda表达式的第一个参数,第一个参数就是调用者，其他参数作为方法参数
//         *      代表person.getAge() - this.getAge()中的this
//         */
//        persons.sort(Person::compare);
//        persons.forEach(item -> System.out.println(item));
//        System.out.println("------------------------------------");
//
//        //方法引用第三种形式的第二个例子
//        List<String> cities = Arrays.asList("shanghai", "beijing", "tianjin");
//        //lambda表达式形式
////        Collections.sort(cities,(city1,city2) -> city1.compareTo(city2));
//        //使用方法引用代替lambda表达式
//        Collections.sort(cities,String::compareTo);
//        cities.forEach(item -> System.out.println(item));
//
//        System.out.println("------------------------------------");
//        /**
//         * 4.构造方法引用
//         */
//        System.out.println(getString(String::new));
//        System.out.println(getString("xx",String::new));
//        Supplier<Person> person = Person::new;
//        System.out.println(person);
//
//        System.out.println("------------------------------------");
//        /**
//         * 测试只能使用方法引用,不能使用lambda表达式
//         */
//        List<Person> personList = Arrays.asList(new Person[]{new Person("zs",18),new Person("ls",28),new Person("ww",38)});
//        personList.forEach(System.out::println);
//        personList.forEach(p -> System.out.println(p.getUsername()));

    }

    /**
     * 测试构造方法引用1
     * @param supplier
     * @return
     */
    public static String getString(Supplier<String> supplier){
        return supplier.get() + "test";
    }

    /**
     * 测试构造方法引用2
     * @param string
     * @param function
     * @return
     */
    public static String getString(String string,Function<String,String> function){
        return function.apply(string) + "test";
    }
}

class Person {
    private String username;
    private Integer age;

    public Person() {
    }

    public Person(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int compare(Person person){
        return person.getAge() - this.getAge() ;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}


class MyClass {
    static void printMessage(String message) {
        System.out.println(message);
    }
}