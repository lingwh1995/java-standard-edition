package org.bluebridge.set;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 哈希保证元素唯一性
 * 链表保证元素有序
 * @author ronin
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("a");
        set.add("b");
        set.add("a");
        set.add("c");
        set.add("b");
        set.add("d");

        for(String s:set){
            System.out.println(s);
        }
    }
}
