package optional;

import java.util.*;

/**
 * 不能作为方法参数,通常作为返回值,来规避空指针异常
 * @author ronin
 */
public class OptionalTest {
    public static void main(String[] args) {
        //第一个构造方法
        Optional<String> optional = Optional.of("hello world!");
        if(optional.isPresent()){
            System.out.println(optional.get());
        }
        System.out.println("------------------------------------");
        optional.ifPresent(item -> System.out.println(item));

        /**
         * 如果是空的就不进行打印
         */
        Optional<String> empty = Optional.empty();
        empty.ifPresent(item -> System.out.println(item));
        System.out.println("------------------------------------");
        /**
         * 如果为空的话就打印xxx
         */
        System.out.println(empty.orElse("xxx"));
        System.out.println(optional.orElse("xxx"));
        System.out.println("------------------------------------");
        /**
         * 如果为空从Supplier中获取值并打印
         */
        System.out.println(empty.orElseGet(()->"get from Supplier......"));
        System.out.println(optional.orElseGet(()->"get from Supplier......"));

        System.out.println("------------------------------------");
        //第二个构造方法
        Optional<String> ofNullAble = Optional.ofNullable("abc");
        ofNullAble.ifPresent(item -> System.out.println(item));

        System.out.println("------------------------------------");
        //List<String> list = Arrays.asList("a","b","c");
        List<String> list = Arrays.asList();
        System.out.println(Optional.ofNullable(list).orElse(Collections.emptyList()));
    }
}
