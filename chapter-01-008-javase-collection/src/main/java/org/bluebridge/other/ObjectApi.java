package org.bluebridge.other;

/**
 * @author ronin
 */
public class ObjectApi {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        //equals()
        System.out.println(p1.equals(p2));

        //equals()
        User u1 = new User();
        User u2 = new User();
        System.out.println(u1.equals(u2));
    }
}

class Person{

}

class User{
    /**
     * 永远返回true
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}