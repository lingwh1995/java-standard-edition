package com.dragonsoft.serializable.externalizable;

import java.io.IOException;

/**
 * @author ronin
 */
public class PersonTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Operate operate=new Operate();
        Person person=new Person("小浩","123456","20");
        System.out.println("为序列化之前的相关数据如下:\n"+person.toString());
        operate.serializable(person);
        Person newPerson=operate.deSerializable();
        System.out.println("-------------------------------------------------------");
        System.out.println("序列化之后的相关数据如下:\n"+newPerson.toString());
    }
}
