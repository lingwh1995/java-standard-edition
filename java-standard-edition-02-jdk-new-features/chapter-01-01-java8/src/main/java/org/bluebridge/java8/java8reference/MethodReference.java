package org.bluebridge.java8.java8reference;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 方法引用用来替换部分lambda表达式,方法引用是lambda的一种语法糖
 * 
 * 当要传递给lambda体的操作，已经有了实现方法了，可以使用方法引用
 * 方法引用可以看做是lambda表达式深层次的表达。实际上，方法引用就是lambda表达式，也就是函数式接口的一个实例，通过方法的名字来指向一个方法
 * 
 * 方法引用的四种使用方式
 * 		静态方法引用 	 	类名 :: staticMethodName
 * 		实例方法引用	 	instanceReference::instanceMethodName 
 * 		构造方法引用	 	类名::new
 * 		类成员方法引用  	类名::methodName
 *
 * lambda要求：	实现接口的抽象方法的参数列表和返回值类型，必须与方法引用的方法的参数列表和返回值类型保持一直
 * @author ronin
 */
public class MethodReference {
	
	/**
	 * 情况一: 静态方法引用
	 * 		Integer::parseInt
	 */
	@Test
	public void test1(){
		//匿名内部类
		Function<String,Integer> function = new Function<String,Integer>() {
			@Override
			public Integer apply(String t) {
				return Integer.parseInt(t);
			}
		};
		Integer apply = function.apply("100");
		System.out.println(apply.getClass().getSimpleName());
		
		//lambda表达式
		(t) -> System.out.println(t);
		
		//方法引用
		Function<String, Integer> stringToInteger = Integer::parseInt;
		int number = stringToInteger.apply("123");// number = 123
		System.out.println(number);
	}
	
	/**
	 * 实例方法引用
	 */
	@Test
	public void test2(){
		String test = "test";
		Supplier<Boolean> notEmpty = test::isEmpty;
		boolean result = notEmpty.get(); // result = false
		System.out.println(result);
	}
	
	/**
	 * 构造方法引用
	 */
	@Test
	public void test3(){
		Supplier<ArrayList<Integer>> listSupplier = ArrayList::new;
		ArrayList<Integer> list = listSupplier.get();
		System.out.println(list);
	}
	
	/**
	 * 类成员方法引用
	 */
	@Test
	public void test4(){
		Consumer<String> printer = MyClass::printMessage;
		printer.accept("Hello, World!"); // 输出 "Hello, World!"
		System.out.println(printer);
	}

	
	
	
	
	/**
	 * 情况一： 对象::实例方法
	 * Consumer		中 	void accept(t)方法
	 * System.out	中	println
	 */
	@Test
	public void testMethodReference1() {
		//匿名内部类
		Consumer<Integer> consumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer i) {
				System.out.println(i);
			}
		};
		consumer.accept(1);
		System.out.println("------------------------------");
		
		
		//lambda表达式
		consumer = i -> System.out.println(i);
		consumer.accept(10);
		System.out.println("------------------------------");
		
		
		//方法引用
		PrintStream ps = System.out;
		consumer = ps::println;
		consumer.accept(100);
		System.out.println("------------------------------");
	}
	
	/**
	 * 情况一： 对象::实例方法
	 * Supplier		中	T 	get()
	 */
	@Test
	public void testMethodReference2() {
		Person person = new Person("张三",128);
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
	 * 情况二： 类::静态方法
	 * Comparator 中 int compare(T t1, T t2)
	 * Integer    中 int compare(T t1, T t2)
 	 */
	@Test
	public void testMethodReference3() {
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
	 * 情况二： 类::静态方法
	 * Math		中 round()
 	 */
	@Test
	public void testMethodReference4() {
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
	 * 情况二： 类::实例方法
	 * Comparator	中的  int compare(T t1, T t2)
	 * String		中的  int t1.compareTo(t2)
 	 */
	@Test
	public void testMethodReference5() {
		//匿名内部类
		Comparator<String> comparator = (s1,s2) -> s1.compareTo(s2);
		System.out.println(comparator.compare("abc", "abd"));
		System.out.println("------------------------------");
		
		
		//方法引用
		comparator = String :: compareTo;
		System.out.println(comparator.compare("abc", "abc"));
		System.out.println("------------------------------");
	}
	
	
	/**
	 * BiPredicate函数接口
	 */
	
	/**
	 * 情况二： 类::实例方法
	 * Comparator	中的  int compare(T t1, T t2)
	 * String		中的  int t1.compareTo(t2)
 	 */
	@Test
	public void testBiPredicate() {
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
	 * 情况一： 对象::实例方法
	 * Consumer		中 	void accept(t)方法
	 * System.out	中	println
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
	
	
	//https://blog.csdn.net/a_beiyo/article/details/142216688
    public static void main(String[] args) {
//        /**
//         * 1.静态方法引用:方法参数由编译器自动识别
//         */
//        Function<String, String> function = String::toUpperCase;
//        System.out.println(function.getClass().getInterfaces()[0]);
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