package com.dragonsoft.generic;

/**
 * @author ronin
 * @date 2019年3月15日
 * @version V1.0
 */
public class GenericInterface {
    /**
     * 泛型接口和泛型类的使用基本相同，泛型接口常被使用在各种类的生产器中
     */

}

interface B<T> {
     T next();
}

/**
 * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
 */
class BB<T> implements B<T>{
    @Override
    public T next() {
        return null;
    }
}


/**
 * 传入泛型实参时：
 * 定义一个生产器实现这个接口,虽然我们只创建了一个泛型接口B<T>
 * 但是我们可以为T传入无数个实参，形成无数种类型的B接口。
 * 在实现类实现泛型接口时，如已将泛型类型传入实参类型，则所有使用泛型的地方都要替换成传入的实参类型
 * 即：Generator<T>，public T next();中的的T都要替换成传入的String类型。
 */
class BBB implements B<String>{
    @Override
    public String next() {
        return null;
    }
}

