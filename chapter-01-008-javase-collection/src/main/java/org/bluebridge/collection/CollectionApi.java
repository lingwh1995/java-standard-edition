package org.bluebridge.collection;

import java.util.*;

/**
 * @author ronin
 */
public class CollectionApi {
    public static void main(String[] args) {
        Collection<String> c1 = new ArrayList<>();
        c1.add("a");
        c1.add("b");
        c1.add("c");
        Collection<String> c2 = new ArrayList<>();
        c2.add("d");
        c2.add("e");
        c2.add("f");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println("--------------------");
        System.out.println(c1.addAll(c2));
        System.out.println(c1);
        System.out.println(c2);

        System.out.println("--------------------");
        Collection<String> c3 = new ArrayList<>();
        c3.add("a");
        c3.add("b");
        c3.add("c");
        Collection<String> c4 = new ArrayList<>();
        c4.add("c");
        c4.add("d");
        c4.add("e");
        Collection<String> c5 = new ArrayList<>();
        c5.add("d");
        c5.add("e");

        System.out.println(c3);
        //只要remove()了就返回true
        System.out.println(c3.removeAll(c4));
        System.out.println(c3.removeAll(c5));
        System.out.println(c3);

        System.out.println("--------------------");
        Collection<String> c6 = new ArrayList<>();
        c6.add("a");
        c6.add("b");
        c6.add("c");
        Collection<String> c7 = new ArrayList<>();
        c7.add("b");
        c7.add("c");
        Collection<String> c8 = new ArrayList<>();
        c8.add("b");
        c8.add("c");
        c8.add("d");

        System.out.println(c6.contains(c7));
        System.out.println(c6.contains(c8));
        System.out.println(c6.containsAll(c7));
        System.out.println(c6.containsAll(c8));

        System.out.println("--------------------");
        Collection<String> c9 = new ArrayList<>();
        c9.add("a");
        c9.add("b");
        c9.add("c");
        Collection<String> c10 = new ArrayList<>();
        c10.add("b");
        Collection<String> c11 = new ArrayList<>();
        c11.add("a");
        c11.add("b");
        c11.add("c");
        Collection<String> c12 = new ArrayList<>();
        c12.add("d");
        c12.add("e");
        //A与B做交集，交集的值保存在A中，方法执行完成后,如果A的值发生了改变,则返回true，如果A的值没发生改变,则返回false
        System.out.println(c9.retainAll(c10));
        System.out.println(c9);
        System.out.println(c11.retainAll(c12));
        System.out.println(c11);


        //使用for循环遍历集合
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        for(Iterator<String> iterator = list.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }
        list.clear();
        System.out.println("调用了clear():"+list);

        Collection<String> c13 = new ArrayList<>();
        c13.add("d");
        c13.add("e");
        System.out.println(Arrays.toString(c13.toArray()));

        System.out.println("---------------------------------");
        List<String> c14 = new ArrayList<String>();
        c14.add("a");
        c14.add("b");
        //contains(Object object)底层是Object类的equals()方法
        System.out.println(c14.contains("a"));
    }
}
