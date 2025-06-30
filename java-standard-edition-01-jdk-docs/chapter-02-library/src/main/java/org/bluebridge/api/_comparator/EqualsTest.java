package org.bluebridge.api._comparator;

import org.junit.Test;

public class EqualsTest {

    @Test
    public void testEquals() {
        Person p1 = new Person("张三",10);
        Person p2 = new Person("张三",10);
        System.out.printf("p1 == p2 : %s\n", p1.equals(p2));
    }
}
