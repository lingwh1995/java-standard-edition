package org.bluebridge.designpattern_05_singleton.singleton_05;

import org.bluebridge.designpattern_05_singleton.singleton_04.Singleton;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}
