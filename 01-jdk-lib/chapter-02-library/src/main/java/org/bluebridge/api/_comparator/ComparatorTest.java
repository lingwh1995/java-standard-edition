package org.bluebridge.api._comparator;

import org.junit.Test;

import java.util.*;

/**
 *   Comparator
 *      1.Comparable是一个排序接口，只包含一个函数compareTo()
 *      2.一个类实现了Comparable接口，就意味着该类本身支持排序，它可以直接通过Arrays.sort() 或 Collections.sort()进行排序。
 *   Comparable
 *      1.它是一个比较器接口，包括两个函数：compare() 和 equals()。
 *      2.一个类实现了Comparator接口，那么它就是一个“比较器”。其它的类，可以根据该比较器去排序。
 *
 *   综上所述：
 *      1.Comparable是内部比较器，而Comparator是外部比较器。
 *      2.一个类本身实现了Comparable比较器，就意味着它本身支持排序；若它本身没实现Comparable，也可以通过外部比较器Comparator进行排序。
 */
public class ComparatorTest {

    /**
     * 测试使用外部比较器接口Comparator对集合进行排序
     */
    @Test
    public void testCollectionComparable() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("a",10));
        personList.add(new Person("b",20));
        personList.add(new Person("c",30));

        //打印list的原始序列
        System.out.printf("原始序列： %s\n",personList);

        //使用外部比较器接口Comparator进行排序
        Collections.sort(personList,new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.printf("按年龄升序排序(使用外部比较器接口Comparator进行排序)： %s\n",personList);

        Collections.sort(personList,new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        System.out.printf("按年龄降序排序(使用外部比较器接口Comparator进行排序)： %s\n",personList);
    }

    /**
     * 测试使用外部比较器接口Comparator对数组进行排序
     */
    @Test
    public void testArrayComparable() {
        Person[] personArr = new Person[3];
        personArr[0] = new Person("a",10);
        personArr[1] = new Person("b",20);
        personArr[2] = new Person("c",30);

        //打印数组的原始序列
        System.out.printf("原始序列： %s\n", personArr);

        //使用外部比较器接口Comparator进行排序
        Arrays.sort(personArr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.printf("按年龄升序排序(使用外部比较器接口Comparator进行排序)： %s\n",Arrays.toString(personArr));

        Arrays.sort(personArr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        System.out.printf("按年龄降序排序(使用外部比较器接口Comparator进行排序)： %s\n",Arrays.toString(personArr));
    }
}
