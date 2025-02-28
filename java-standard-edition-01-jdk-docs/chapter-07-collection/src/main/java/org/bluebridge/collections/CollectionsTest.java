package org.bluebridge.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ronin
 */
public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(19);
        list.add(15);
        list.add(13);
        System.out.println(Collections.max(list));
        Collections.reverse(list);
        System.out.println(list);
        //随机置换,随机打乱元素顺序
        Collections.shuffle(list);
        System.out.println(list);

        //ArrayList存储自定义对象然后进行排序:自然排序
        List<Student> students = new ArrayList<>();
        students.add(new Student("zs",18));
        students.add(new Student("ls",19));
        students.add(new Student("ws",28));

        Collections.sort(students);
        System.out.println(students);

        //ArrayList存储自定义对象然后进行排序:比较器排序
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("aa",15));
        dogs.add(new Dog("bb",16));
        dogs.add(new Dog("cc",17));
        Collections.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog d1, Dog d2) {
                int age = d1.getAge() - d2.getAge();
                return age == 0 ? d1.getName().compareTo(d2.getName()) : age;
            }
        });
        System.out.println(dogs);
    }
}
