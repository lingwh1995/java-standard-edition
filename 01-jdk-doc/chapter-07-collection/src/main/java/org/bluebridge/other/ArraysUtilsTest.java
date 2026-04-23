package org.bluebridge.other;

import java.util.Arrays;
import java.util.List;

/**
 * 数组工具类测试
 * @author ronin
 */
public class ArraysUtilsTest {
    public static void main(String[] args) {
        /**
         * public static <T> List<T> asList(T... a) {}
         * 把数组转换为集合,本质上还是数组，所以只要长度不发生改变,任何操作都可以
         */
        String[] s = {"a","b","c"};
        List<String> l1 = Arrays.asList(s);
        List<String> l2 = Arrays.asList("a,b,c");
        System.out.println(l2);
        System.out.println(l2);
        System.out.println(l2.size()+"---"+l2.get(0));

        Per zs = new Per("zs", "18");
        Per ls = new Per("ls", "19");
        Per ww = new Per("ww", "29");
        List<Per> pers = Arrays.asList(zs, ls, ww);
        System.out.println(pers);
    }
}

class Per{
    private String name;
    private String age;

    public Per(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Per{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}