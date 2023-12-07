package org.bluebridge.list;

import java.util.LinkedList;

/**
 * @author ronin
 */
public class LinkedListApi {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("xxx");
        System.out.println(list);

        list.addFirst("first");
        list.addLast("last");
        System.out.println(list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        System.out.println("-----------------");
        System.out.println("removeFirst:"+list.removeFirst());
        System.out.println(list);
        System.out.println("removeLast:"+list.removeLast());
        System.out.println(list);
    }
}
