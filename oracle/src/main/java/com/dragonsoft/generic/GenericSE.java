package com.dragonsoft.generic;

import java.util.ArrayList;

/**
 * 泛型中:? super extends
 * @author ronin
 */
public class GenericSE {
    public static void main(String[] args) {
        ArrayList<Object> l1 = new ArrayList<Object>();
        ArrayList<Animal> l2 = new ArrayList<Animal>();
        /**
         * 下面代码会报错
         */
        //ArrayList<Object> l3 = new ArrayList<Animal>();
        //ArrayList<Object> l4 = new ArrayList<Dog>();
        //ArrayList<Object> l5 = new ArrayList<Cat>();
        //ArrayList<Animal> l6 = new ArrayList<Cat>();
        //ArrayList<Animal> l6 = new ArrayList<Dog>();
        ArrayList<?> l7 = new ArrayList<Object>();
        ArrayList<?> l8 = new ArrayList<Animal>();
        ArrayList<?> l9 = new ArrayList<Dog>();
        ArrayList<?> l10 = new ArrayList<Cat>();

        //下面代码会报错
        //ArrayList<? extends Animal> l12 = new ArrayList<Object>();
        //? extends E:向下限定,E及其子类
        ArrayList<? extends Animal> l13 = new ArrayList<Animal>();
        ArrayList<? extends Animal> l14 = new ArrayList<Dog>();
        ArrayList<? extends Animal> l15 = new ArrayList<Cat>();


        //? super E:向上限定,E及父类
        ArrayList<? super Animal> l16 = new ArrayList<Object>();
        ArrayList<? super Animal> l17 = new ArrayList<Animal>();

        //下面代码也会报错
        //ArrayList<? super Animal> l18 = new ArrayList<Dog>();
        //ArrayList<? super Animal> l19 = new ArrayList<Cat>();
    }
}
class Animal{

}
class Dog extends Animal{

}
class Cat extends Animal{

}
