package org.bluebridge.list;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @author ronin
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("b");
        list.add("f");
        list.add("g");
        list.add("b");
        System.out.println(list);
        //set
        list.set(0,"set");
        System.out.println(list);
        //indexOf
        System.out.println(list.indexOf("b"));
        //lastIndexOf
        System.out.println(list.lastIndexOf("b"));
        //listIterator
        ListIterator<String> iterator = list.listIterator();
        while(iterator.hasNext()){
            iterator.next();
            System.out.println(iterator.nextIndex());
        }
        System.out.println("-----------------------");
        System.out.println(iterator.previousIndex());

        //listIterator(int index);从下标为2的元素开始遍历
        System.out.println("------------------------");
        ListIterator<String> listIterator = list.listIterator(2);
        while(listIterator.hasNext()){
            listIterator.next();
            System.out.println(listIterator.nextIndex());
        }
        System.out.println("-----------------------");
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
    }
}


