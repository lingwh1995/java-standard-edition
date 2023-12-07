package functioninterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate:谓语、谓词、判断,类似与英语中am/is/are的作用
 * @author ronin
 */
public class PredicateFunctionInterfaceTest {
    public static void main(String[] args) {
        //函数式接口Predicate配合lambda表达式的基础使用
        predicateWithLambda();

        /**
         * 使用一个Predicate实例做判断
         */
        List<Integer> elements = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("------------------------------------");
        //打印集合中所有奇数元素
        conditionFiler(elements,p->p%2!=0);
        System.out.println("------------------------------------");
        //打印集合中所有偶数元素
        conditionFiler(elements,p->p%2==0);
        System.out.println("------------------------------------");
        //打印集合中所有>5的元素
        conditionFiler(elements,p->p>5);
        System.out.println("------------------------------------");
        //打印集合中所有的元素
        conditionFiler(elements,p->true);

        /**
         * 使用多个个Predicate实例做逻辑判断
         */

        System.out.println("------------------------------------");
        //打印大于5并且是偶数的元素
        conditionFilerWithLogicJudgment1(elements,p1->p1>5,p2->p2%2==0);
        System.out.println("------------------------------------");
        //打印小于5或者是偶数的元素
        conditionFilerWithLogicJudgment2(elements,p1->p1<5,p2->p2%2==0);
        System.out.println("------------------------------------");
        //打印满足对 小于5 这个条件取反的元素
        conditionFilerWithLogicJudgment3(elements,p1->p1<5);
        System.out.println("------------------------------------");
        System.out.println(isEqual("test").test("test"));
    }

    /**
     * 函数式接口Predicate配合lambda表达式的基础使用
     */
    private static void predicateWithLambda() {
        /**
         * expression形式1:什么都不省略
         */
        Predicate<Integer> predicate1 = (Integer i) -> i>10 ;
        System.out.println(predicate1.test(5));

        /**
         * expression形式2:省略数据类型
         */
        Predicate<Integer> predicate2 = (i) -> i>10 ;
        System.out.println(predicate2.test(5));

        /**
         * expression形式3:省略数据类型和括号
         */
        Predicate<Integer> predicate3 = i-> i>10 ;
        System.out.println(predicate3.test(5));
    }

    /**
     * 通用的条件过滤方法
     * @param elements 元数据
     * @param predicate
     */
    private static void conditionFiler(List<Integer> elements,Predicate<Integer> predicate){
        elements.forEach(element -> {
            if(predicate.test(element)){
                System.out.println(element);
            }
        } );
    }

    /**
     * 通用的条件过滤方法,并包含多个Predicate实例的逻辑判断
     *      大于5并且是偶数
     * @param elements 元数据
     * @param predicate1 条件1
     * @param predicate1 条件2
     */
    private static void conditionFilerWithLogicJudgment1(List<Integer> elements,Predicate<Integer> predicate1,Predicate<Integer> predicate2){
        elements.forEach(element -> {
            if(predicate1.and(predicate2).test(element)){
                System.out.println(element);
            }
        } );
    }

    /**
     * 通用的条件过滤方法,并包含多个Predicate实例的逻辑判断
     *      小于5或者是偶数
     * @param elements 元数据
     * @param predicate1 条件1
     * @param predicate1 条件2
     */
    private static void conditionFilerWithLogicJudgment2(List<Integer> elements,Predicate<Integer> predicate1,Predicate<Integer> predicate2){
        elements.forEach(element -> {
            if(predicate1.or(predicate2).test(element)){
                System.out.println(element);
            }
        } );
    }

    /**
     * 通用的条件过滤方法,并包含一个Predicate实例的逻辑判断
     *      对小于5取反
     * @param elements 元数据
     * @param predicate 小于5
     */
    private static void conditionFilerWithLogicJudgment3(List<Integer> elements,Predicate<Integer> predicate){
        elements.forEach(element -> {
            if(predicate.negate().test(element)){
                System.out.println(element);
            }
        } );
    }

    /**
     * 判断两个参数是不是相等的,对Object类的equals()方法做了包装
     * @param object
     * @return
     */
    public static Predicate<String> isEqual(Object object){
        return Predicate.isEqual(object);
    }
}
