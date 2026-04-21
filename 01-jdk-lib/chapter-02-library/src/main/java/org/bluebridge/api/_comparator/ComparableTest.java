package org.bluebridge.api._comparator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
public class ComparableTest {

    /**
     * 测试使用内部比较器接口Comparable对集合进行排序
     */
    @Test
    public void testCollectionComparable() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("a",10));
        personList.add(new Person("b",10));
        personList.add(new Person("c",10));

        //打印list的原始序列
        System.out.printf("原始序列： %s\n",personList.toString());

        //使用内部比较器接口Comparable<String>进行排序
        Collections.sort(personList);
        System.out.printf("按名字进行排序(内部比较器接口Comparable)： %s\n",personList.toString());
    }
}
