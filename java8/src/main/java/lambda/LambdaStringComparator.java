package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @author ronin
 */
public class LambdaStringComparator {
    public static void main(String[] args) {
        List<String> elements = Arrays.asList("1", "3", "2");
        /**
         * 1.
         */
//        Collections.sort(elements, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
        System.out.println(elements);
        System.out.println("----------------------------");

        /**
         * 2.
         */
//        Collections.sort(elements,(String s1,String s2)->{
//            return s1.compareTo(s2);
//        });
        System.out.println(elements);
        System.out.println("----------------------------");

        /**
         * 3.
         */
//        Collections.sort(elements,Comparator.reverseOrder());
        System.out.println(elements);
        System.out.println("----------------------------");

        /**
         * 4.
         */
//        Collections.sort(elements,(String s1,String s2)-> s1.compareTo(s2));
        System.out.println(elements);
        System.out.println("----------------------------");

        /**
         * 5.
         */
        Collections.sort(elements,(s1,s2)-> s1.compareTo(s2));
        System.out.println(elements);

        //当方法体中只有一条语句的时候,有两种形式的写法
        //expression(表达式风格) ->s1.compareTo(s2)
        //statement(块风格,语句后面必须加分号) ->{return s1.compareTo(s2);}
    }
}
