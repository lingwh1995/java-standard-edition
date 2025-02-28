package org.bluebridge.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 如何ConcurrentModificationException
 * @author ronin
 */
public class CollectionConcurrentModificationExceptionTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //fun1(list);
        fun2(list);
    }

    /**
     * 解决方案1:迭代器遍历+迭代器删除或者迭代器增加
     * @param list
     */
    private static void fun1(List<String> list) {
        ListIterator<String> iterator = list.listIterator();
        System.out.println(list);
        while (iterator.hasNext()){
            String element = (String)iterator.next();
            //会发生ConcurrentModificationException
            //list.add("xxxx");
            if("a".equals(element)) {
                iterator.add("xxxx");
            }
        }
        System.out.println(list);
    }

    /**
     * 解决方案2:for循环遍历+集合修改元素
     * @param list
     */
    private static void fun2(List<String> list) {
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            //System.out.println(list.get(i));
            if("a".equals(list.get(i))){
                list.add("yyyy");
            }
        }
        System.out.println(list);
    }
}
