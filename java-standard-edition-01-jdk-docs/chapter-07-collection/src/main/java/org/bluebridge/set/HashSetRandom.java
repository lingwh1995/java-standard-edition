package org.bluebridge.set;

import java.util.HashSet;
import java.util.Random;

/**
 * 10个不重复的随机数,范围是:0-20
 * 原理:
 *      HashSet+Integer保证唯一性
 *      Integer虽然是引用类型数据,但是已经实现了Comparable接口,可以保证元素的唯一性
 * @author ronin
 */
public class HashSetRandom {
    public static void main(String[] args) {
        HashSet<Integer> integers = new HashSet<>();
        Random random = new Random();
        while (integers.size()<10){
            integers.add(random.nextInt(20)+1);
        }
        System.out.println(integers);
    }
}
