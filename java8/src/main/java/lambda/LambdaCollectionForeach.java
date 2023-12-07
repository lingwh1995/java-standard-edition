package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/9/25 8:55
 */
public class LambdaCollectionForeach {
    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(1,2,3);
        for(Integer element:elements){
            System.out.println(element);
        }
        System.out.println("--------------------");
        elements.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        System.out.println("--------------------");
        elements.forEach(i->{
            System.out.println(i);
        });
        System.out.println("--------------------");
        elements.forEach((Integer i)->{
            System.out.println(i);
        });
        System.out.println("--------------------");
        elements.forEach((Integer value)->{
            System.out.println(value);
        });
        System.out.println("--------------------");
        //方法引用式调用
        elements.forEach(System.out::println);
        System.out.println("--------------------");
        elements.stream().map(item->item+1).forEach(item-> System.out.println(item));
    }
}
