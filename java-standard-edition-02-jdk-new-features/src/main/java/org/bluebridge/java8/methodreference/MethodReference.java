package org.bluebridge.java8.methodreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用用来替换部分lambda表达式,方法引用是lambda的一种语法糖
 * 方法引用的四种方法
 * @author ronin
 */
public class MethodReference {
    public static void main(String[] args) {
        /**
         * 1.静态方法引用:方法参数由编译器自动识别
         */
        Function<String, String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);

        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        list.forEach(item -> System.out.println(item));
        System.out.println("------------------------------------");
        list.forEach(System.out::println);

        System.out.println("------------------------------------");
        //排序
        //lambda写法
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("ls",28));
        persons.add(new Person("zs",18));
        persons.add(new Person("ww",48));
        persons.add(new Person("ls",38));
        //persons.sort((p1,p2) -> Person.compare(p1,p2));
        persons.forEach(item -> System.out.println(item));
        System.out.println("------------------------------------");
        //方法引用写法
        //persons.sort(PersonComparator::compareStatic);
        persons.forEach(item -> System.out.println(item));

        System.out.println("------------------------------------");
        /**
         * 2.实例方法引用:方法参数由编译器自动识别
         *      注意:被引用的方法不能是静态的,会报错
         */
        PersonComparator personComparator = new PersonComparator();
        //persons.sort((p1,p2) -> personComparator.compareNoStatic(p1,p2));
        //persons.sort(personComparator::compareNoStatic);
        persons.forEach(item -> System.out.println(item));
        System.out.println("------------------------------------");

        /**
         * 3.类名::实例方法名
         *      方法的调用者是lambda表达式的第一个参数,第一个参数就是调用者，其他参数作为方法参数
         *      代表person.getAge() - this.getAge()中的this
         */
        persons.sort(Person::compare);
        persons.forEach(item -> System.out.println(item));
        System.out.println("------------------------------------");

        //方法引用第三种形式的第二个例子
        List<String> cities = Arrays.asList("shanghai", "beijing", "tianjin");
        //lambda表达式形式
//        Collections.sort(cities,(city1,city2) -> city1.compareTo(city2));
        //使用方法引用代替lambda表达式
        Collections.sort(cities,String::compareTo);
        cities.forEach(item -> System.out.println(item));

        System.out.println("------------------------------------");
        /**
         * 4.构造方法引用
         */
        System.out.println(getString(String::new));
        System.out.println(getString("xx",String::new));
        Supplier<Person> person = Person::new;
        System.out.println(person);

        System.out.println("------------------------------------");
        /**
         * 测试只能使用方法引用,不能使用lambda表达式
         */
        List<Person> personList = Arrays.asList(new Person[]{new Person("zs",18),new Person("ls",28),new Person("ww",38)});
        personList.forEach(System.out::println);
        personList.forEach(p -> System.out.println(p.getUsername()));

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
