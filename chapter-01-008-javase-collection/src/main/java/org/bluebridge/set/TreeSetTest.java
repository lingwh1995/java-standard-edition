package org.bluebridge.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeSet(有序且唯一):能对元素按照某种规则进行排序
 * 排序有两种:
 *      自然排序(元素具备比较性)：
 *          需要实现Comparable<T>并重写compareTo()方法,与hashCode()和equals()
 *          无关,不需要重写这两个方法
 *      比较器排序(集合具备比较性):
 *          在TreeSet的构造方法中传入Comparator的子类
 * 底层数据结构是红黑树
 * @author ronin
 */
public class TreeSetTest {
    public static void main(String[] args) {
        //自然排序:存储Integer
        //自然排序(Comparator):存储Integer
        TreeSet<Integer> integers = new TreeSet<>();
        integers.add(10);
        integers.add(1);
        integers.add(1);
        integers.add(89);
        integers.add(13);
        System.out.println(integers);

        System.out.println("-------------------------");
        //比较器排序(Comparable):存储自定义对象
        TreeSet<Dog> dogs = new TreeSet<>();
        dogs.add(new Dog("zs",15));
        dogs.add(new Dog("ls",16));
        dogs.add(new Dog("ww",18));
        dogs.add(new Dog("zl",11));
        dogs.add(new Dog("zs",15));
        for(Dog dog:dogs){
            System.out.println(dog);
        }

        System.out.println("-------------------------");
        //自然排序(Comparator):存储自定义对象
        TreeSet<Cat> cats = new TreeSet<>(new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                //主要条件
                int age =  o2.age - o1.age;
                //次要条件
                return  age == 0 ? o1.name.compareTo(o2.name) : age;
            }
        });
        cats.add(new Cat("zs",18));
        cats.add(new Cat("aa",18));
        cats.add(new Cat("bb",18));
        cats.add(new Cat("ls",19));
        cats.add(new Cat("ww",20));
        cats.add(new Cat("zs",21));
        cats.add(new Cat("zs",18));
        for(Cat cat:cats){
            System.out.println(cat);
        }
    }
}

class Dog implements Comparable<Dog>{
    private String name;
    private Integer age;

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Dog dog) {
        if(this.name == dog.name && this.age == dog.age){
            return 0;
        }
        return this.age > dog.age ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Cat{
    protected String name;
    protected Integer age;

    public Cat(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
